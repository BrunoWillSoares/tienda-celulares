package com.tienda.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadopago.resources.Preference;
import com.tienda.apirest.resources.CelularResource;
import com.tienda.business.CelularBuyBusiness;
import com.tienda.business.MercadoPagoAPI;
import com.tienda.business.MercadoPagoSDK;
import com.tienda.models.Celular;
import com.tienda.models.PaymentMethod;
import com.tienda.models.Preferencia;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApiRestApplicationTests {

	@Test
	@Order(1)
	public void obterFormasPagamentoRestTest() {
		CelularResource resource = new CelularResource();
		List<PaymentMethod> list = resource.obterFormasPagamento();

		assertThat("Empty list is not expected", list, is(not(empty())));
		//Just to see what has returned 
		for (PaymentMethod paymentMethod : list) {
			System.out.println(paymentMethod.getId() + " - " + paymentMethod.getPayment_type_id());
		}

		assertThat("Invalid Payment Returned! Amex is not accepted! ", list,  not( hasItem (hasProperty("id", is("amex")))));
		assertThat("Invalid Payment Returned! ATM is not accepted! ", list,  not( hasItem (hasProperty("payment_type_id", is("atm")))));

	}
	
	
	@Test
	@Order(2)
	public void criarPreferencias() {
		CelularBuyBusiness business = new  CelularBuyBusiness();
		CelularResource resource = new CelularResource();
		
		List<Celular> celulares = resource.listaCelulares();
		
		for (Celular celular : celulares) {
			if(business.criarPreferencia(celular) == null) {
				assertTrue("Error creating preference!", false);
			}
		}
	}
	
	
	@Test
	@Order(3)
	public void obterPreferenciasSDK() {
		MercadoPagoSDK api = new MercadoPagoSDK();
		Preference preferencia =  api.obterPreferencias("469485398-d320b7b8-e6ae-4d59-ad7f-6c8d4272cbf6");
		assertNotNull("Empty list is not expected", preferencia);
		
		System.out.println("Preferencia localizada: " + preferencia.getId() + "\n => " + preferencia.getItems().get(0).getTitle());
	}
	
	
	@Test
	@Order(4)
	public void obterPreferenciasAPI() {
		MercadoPagoAPI api = new MercadoPagoAPI();
		List<Preferencia> preferencias =  api.obterPreferencias();
		assertThat("Empty list is not expected", preferencias, is(not(empty())));
		
		
		
	}

	
}
