package com.tienda.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tienda.models.PaymentMethod;

public class CelularBuyBusiness {

	// 1 to 6 installments
	// Forbid AMEX cards
	// Forbid ATM Payment Type
	public List<PaymentMethod> obterFormasPagamento() {
		List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		List<PaymentMethod> paymentMethodsResponse = null;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		//TODO: Change information source to application.properties for security
		//TODO: Decrypt from above source
		headers.set("Authorization", "Bearer APP_USR-6317427424180639-042414-47e969706991d3a442922b0702a0da44-469485398");
		HttpEntity<?> header = new HttpEntity<Object>(headers);
		
		ResponseEntity<List<PaymentMethod> > response = restTemplate.exchange("https://api.mercadopago.com/v1/payment_methods", HttpMethod.GET, header,new ParameterizedTypeReference<List<PaymentMethod>>() {});
		paymentMethodsResponse = response.getBody();
		
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

}
