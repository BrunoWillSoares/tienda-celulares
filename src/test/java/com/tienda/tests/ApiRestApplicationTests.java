package com.tienda.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tienda.apirest.resources.CelularResource;
import com.tienda.models.PaymentMethod;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApiRestApplicationTests {

	@Test
	public void obterFormasPagamentoRestTest() {
		CelularResource resource = new CelularResource();
		List<PaymentMethod> list = resource.obterFormasPagamento();

		//Just to see what has returned 
		for (PaymentMethod paymentMethod : list) {
			System.out.println(paymentMethod.getId() + " - " + paymentMethod.getPayment_type_id());
		}

		assertThat("Invalid Payment Returned! Amex is not accepted! ", list,  not( hasItem (hasProperty("id", is("amex")))));
		assertThat("Invalid Payment Returned! ATM is not accepted! ", list,  not( hasItem (hasProperty("payment_type_id", is("atm")))));

	}
	
}
