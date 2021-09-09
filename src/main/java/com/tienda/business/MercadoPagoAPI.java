package com.tienda.business;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tienda.models.PaymentMethod;
import com.tienda.models.Preferencia;

public class MercadoPagoAPI {
	
	private static String HEADER_AUTHORIZATION = "Authorization";
	private static String HEADER_CONTENT_TYPE = "Content-Type";
	private static String JSON_CONTENT_TYPE = "application/json";
	
	private HttpEntity<?> HEADER = new HttpEntity<Object>(null);
	
	//TODO: Change information source to application.properties for security
	//TODO: Decrypt from above source
	private static String authorizationToken = "Bearer APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398";
	
	private static String apiPayment_Methods_EndPoint = "https://api.mercadopago.com/v1/payment_methods";
	private static String apiPreferences_EndPoint = "https://api.mercadopago.com/checkout/preferences/search?sponsor_id=undefined&external_reference=undefined&site_id=undefined&marketplace=undefined";
	//private static String apiCreatePreference_EndPoint = "https://api.mercadopago.com/checkout/preferences";

	
	public MercadoPagoAPI() {
		super();
		HttpHeaders headers = new HttpHeaders();
		headers.set(HEADER_AUTHORIZATION, authorizationToken);
		headers.set(HEADER_CONTENT_TYPE, JSON_CONTENT_TYPE);
		HEADER = new HttpEntity<Object>(headers);
	}

	public List<PaymentMethod> obterFormasPagamento() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<PaymentMethod> > response = restTemplate.exchange(apiPayment_Methods_EndPoint, 
				HttpMethod.GET, HEADER,new ParameterizedTypeReference<List<PaymentMethod>>() {});

		return response.getBody();
	}

	public List<Preferencia> obterPreferencias() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Preferencia> > response = restTemplate.exchange(apiPreferences_EndPoint, 
				HttpMethod.GET, HEADER,new ParameterizedTypeReference<List<Preferencia>>() {});

		return response.getBody();
	}
	
//	public boolean criarPreferencia(Celular celular) {
//		RestTemplate restTemplate = new RestTemplate();
//		RequestEntity<String>
//		ResponseEntity<List<PaymentMethod> > response = restTemplate.exchange(apiCreatePreference_EndPoint, 
//				HttpMethod.POST, HEADER, 
//				
//				new ParameterizedTypeReference<List<PaymentMethod>>() {});
//
//		return response.getBody();
//		return true;
//	}
	
}
