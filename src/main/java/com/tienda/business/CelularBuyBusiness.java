package com.tienda.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mercadopago.resources.Preference;
import com.tienda.models.Celular;
import com.tienda.models.Item;
import com.tienda.models.PaymentMethod;
import com.tienda.models.Preferencia;

public class CelularBuyBusiness {
	
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	private static boolean PRODUCAO = false;

	private static MercadoPagoAPI apiMercadoPago = new MercadoPagoAPI();
	private static MercadoPagoSDK sdkMercadoPago = new MercadoPagoSDK();
	
	// 1 to 6 installments
	// Forbid AMEX cards
	// Forbid ATM Payment Type
	public List<PaymentMethod> obterFormasPagamento() {
		List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		List<PaymentMethod> paymentMethodsResponse = null;
		
		paymentMethodsResponse = apiMercadoPago.obterFormasPagamento();
		//TODO: Change information source to application.properties for flexibility
		for (PaymentMethod method : paymentMethodsResponse) {
			if(method.getStatus().equalsIgnoreCase("active")) {
				if(!method.getId().equalsIgnoreCase("amex")) {
					if(!method.getPayment_type_id().equalsIgnoreCase("atm")) {
						paymentMethods.add(method);
					}
				}
			}
		}
		
		return paymentMethods;
	}
	
	public Preference criarPreferencia(Celular celular) {
		return sdkMercadoPago.criarPreferencia(celular);
	}

	public Preferencia comprar(Celular celular) {
		Preference preference = this.criarPreferencia(celular);
		Preferencia preferencia = new Preferencia();
		if(preference != null && preference.getId() != null 
				&& preference.getCollectorId() !=null
				&& preference.getClientId() != null
				&& preference.getDateCreated() != null) {
			preferencia.setId(preference.getId());
			preferencia.setCollector_id(preference.getCollectorId().toString());
			preferencia.setClient_id(preference.getClientId().toString());
			preferencia.setDate_created(SDF.format(preference.getDateCreated()));
			
			Item item = new Item();
			item.setId(preference.getItems().get(0).getId());
			List<Item> itens = new ArrayList<Item>();
			itens.add(item);
			preferencia.setItems(itens);
			
			if(PRODUCAO) {
				preferencia.setInit_point(preference.getInitPoint());
			}else {
				preferencia.setInit_point(preference.getSandboxInitPoint());
			}
			
		}
		return preferencia;
	}

}
