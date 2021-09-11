package com.tienda.business;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.Preference.AutoReturn;
import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.ExcludedPaymentMethod;
import com.mercadopago.resources.datastructures.preference.ExcludedPaymentType;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.PaymentMethods;
import com.mercadopago.resources.datastructures.preference.Phone;
import com.tienda.models.Celular;

public class MercadoPagoSDK {
	private static String SERVER_URL="https://tienda-celulares-frontend.herokuapp.com";
	private static String WEBHOOK_ENDPOINT = "/webhook";
	//private static String SERVER_URL="http://localhost:4200";
	
	private static String SUCCESS_URL="/Success";
	private static String FAIL_URL="/Fail";
	private static String PENDING_URL="/Pending";
	
	private static String DEFAULT_CURRENCY = "BRL";
	private static String authorizationToken = "APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398";
	private static String integrator_id = "dev_24c65fb163bf11ea96500242ac130004";
	
	
	public MercadoPagoSDK() {
		super();
		try {
			MercadoPago.SDK.setAccessToken(authorizationToken);
			MercadoPago.SDK.setIntegratorId(integrator_id);
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
			backUrls.setSuccess(SERVER_URL + SUCCESS_URL);
			backUrls.setFailure(SERVER_URL + FAIL_URL);
			backUrls.setPending(SERVER_URL + PENDING_URL);

			Item item = new Item();
			//According to given directions
			item.setId("1234");
			item.setTitle(celular.getMarca() + " " + celular.getModelo());
			item.setDescription("Dispositivo móvil de Tienda e-commerce");
			item.setPictureUrl(SERVER_URL+celular.getCaminhoImagem());
			item.setCategoryId("celulares1");
			item.setCurrencyId(DEFAULT_CURRENCY);
			
			item.setQuantity(1);
			item.setUnitPrice(Float.valueOf(celular.getValor().replace(",", ".")));
			
			preference.setExternalReference("bruno.p.soares@gmail.com");
			
			preference.appendItem(item);
			preference.setAutoReturn(AutoReturn.all);
			preference.setBackUrls(backUrls);
			
			PaymentMethods excludedPayments = new PaymentMethods();
			excludedPayments.appendExcludedPaymentMethod(new ExcludedPaymentMethod("amex"));
			excludedPayments.appendExcludedPaymentTypes(new ExcludedPaymentType("atm"));
			excludedPayments.setInstallments(6);
			
			preference.setPaymentMethods(excludedPayments);
			
			
			preference.setPayer(this.obterPagador());
			
			preference.setNotificationUrl(SERVER_URL + WEBHOOK_ENDPOINT);
			
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
				+ "Id_Preferencia: [" +  preferencia.getId() +"] Item:[" + preferencia.getItems().get(0).getTitle() +
				"] Coletor: " + preferencia.getCollectorId() + " + Client ID: " + preferencia.getClientId() + 
				"- Criado com sucesso. Caminho:" + preferencia.getSandboxInitPoint()
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
	
	private Payer obterPagador() {
		Payer payerTest = new Payer();
		Phone payerPhone = new Phone();
		Address payerAddress = new Address();
		
		payerTest.setName("Lalo");
		payerTest.setSurname("Landa");
		
		payerPhone.setAreaCode("11");
		payerPhone.setNumber("22223333");
			
		payerTest.setPhone(payerPhone);
		
		payerTest.setEmail("test_user_63274575@testuser.com");
		
		payerAddress.setStreetName("Falsa");
		payerAddress.setStreetNumber(123);
		payerAddress.setZipCode("1111");
		payerTest.setAddress(payerAddress);
		
		
		return payerTest;
	}

}
