package com.tienda.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.tienda.business.CelularBuyBusiness;
import com.tienda.models.PaymentMethod;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApiRestApplicationTests {

	@Test
	public void getPaymentMethods() {
		CelularBuyBusiness business = new CelularBuyBusiness();
		List<PaymentMethod> list = business.obterFormasPagamento();

		//Just to see what has returned 
		for (PaymentMethod paymentMethod : list) {
			System.out.println(paymentMethod.getId());
		}

		assertThat("Invalid Payment Returned! Amex is not acceptable! ", list,  not( hasItem (hasProperty("id", is("amex")))));

	}

}
