package com.tienda.business;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.Preference.AutoReturn;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.ExcludedPaymentMethod;
import com.mercadopago.resources.datastructures.preference.ExcludedPaymentType;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.PaymentMethods;
import com.tienda.models.Celular;

public class MercadoPagoSDK {
	private static String SERVER_URL="https://tienda-celulares-frontend.herokuapp.com";
	private static String DEFAULT_CURRENCY = "BRL";
	private static String authorizationToken = "APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398";
	
	
	
	public MercadoPagoSDK() {
		super();
		try {
			MercadoPago.SDK.setAccessToken(authorizationToken);
		} catch (MPConfException e) {
			e.printStackTrace();
		}
	}

	public Preference criarPreferencia(Celular celular) {
		Preference preferencia = null;

		// TODO: Change information source to application.properties for security
		// TODO: Decrypt from above source
		try {
			// Cria um objeto de preferência
			Preference preference = new Preference();
			
			BackUrls backUrls = new BackUrls();
			backUrls.setSuccess(SERVER_URL);
			backUrls.setFailure(SERVER_URL);
			backUrls.setPending(SERVER_URL);

			// Cria um item na preferência
			Item item = new Item();
			item.setId(celular.getId().toString());
			item.setTitle(celular.getModelo());
			item.setDescription(celular.getMarca() + " " + celular.getModelo());
			item.setPictureUrl(SERVER_URL+celular.getCaminhoImagem());
			item.setCategoryId("celulares1");
			item.setCurrencyId(DEFAULT_CURRENCY);
			
			item.setQuantity(1);
			item.setUnitPrice(Float.valueOf(celular.getValor().replace(",", ".")));
			
			preference.appendItem(item);
			preference.setAutoReturn(AutoReturn.all);
			preference.setBackUrls(backUrls);
			
			PaymentMethods excludedPayments = new PaymentMethods();
			excludedPayments.appendExcludedPaymentMethod(new ExcludedPaymentMethod("amex"));
			excludedPayments.appendExcludedPaymentTypes(new ExcludedPaymentType("atm"));
			
			preference.setPaymentMethods(excludedPayments);
			
			preferencia = preference.save();
		} catch (MPConfException e) {
			System.out.println("======================");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MPException e) {
			System.out.println("======================adfsads");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Bad Requests
		if(preferencia.getCollectorId() == null) {
			return null;
		}
		
		System.out.println("\n==============\n"
				+ "Id_Preferencia: [" +  preferencia.getId() +"] Item:[" + preferencia.getItems().get(0).getTitle() + "] Coletor: " + preferencia.getCollectorId() + " + Client ID: " + preferencia.getClientId() + "- Criado com sucesso. Caminho:" + preferencia.getSandboxInitPoint()
				+ "\n==============\n");
		return preferencia;
	}

	public Preference obterPreferencias(String id) {
		try {
			return Preference.findById(id);
		} catch (MPException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
