package com.tienda.business;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.tienda.models.Celular;

public class CelularBusiness {

	public List<Celular> obterCelulares() {
		List<Celular> celulares = new ArrayList<Celular>();
		
		Celular iPhone = new Celular(1,"Apple", "iPhone 12 Pro Max", new BigDecimal(200), new BigDecimal(9000), "./imagens/iphone.jpg");
		Celular s21 = new Celular(1,"Samsung", "Galaxy S21 Ultra", new BigDecimal(200), new BigDecimal(6100), "./imagens/s21-ultra.jpg");
		Celular note = new Celular(1,"Samsung", "Galaxy Note 20", new BigDecimal(200), new BigDecimal(3100), "./imagens/note20.png");
		Celular motorola = new Celular(1,"Motorola", "Edge 20 Pro", new BigDecimal(200), new BigDecimal(4999), "./imagens/motorola_edge.png");
		
		celulares.add(iPhone);
		celulares.add(s21);
		celulares.add(note);
		celulares.add(motorola);
		
		return celulares;
	}

}
