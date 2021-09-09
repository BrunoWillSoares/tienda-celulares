package com.tienda.business;

import java.util.ArrayList;
import java.util.List;

import com.mercadopago.resources.Preference;
import com.tienda.models.Celular;
import com.tienda.models.PaymentMethod;

public class CelularBuyBusiness {

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

	public Preference comprar(Celular celular) {
		return this.criarPreferencia(celular);
	}

}
