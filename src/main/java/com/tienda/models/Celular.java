package com.tienda.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;


//@Entity
//@Table(name="TB_CELULAR")
public class Celular implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String marca;
	
	@NotNull
	private String modelo;
	
	@NotNull
	private BigDecimal quantidade;
	
	@NotNull
	private String valor;
	
	@NotNull
	private String caminhoImagem;
	
	
	
	public Celular() {
		super();
		
	}
	public Celular(long id, @NotNull String marca, @NotNull String modelo, @NotNull BigDecimal quantidade,
			@NotNull String valor, @NotNull String caminhoImagem) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.quantidade = quantidade;
		this.valor = valor;
		this.caminhoImagem = caminhoImagem;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public BigDecimal getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	@Override
	public String toString() {
		return "Celular [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", quantidade=" + quantidade
				+ ", valor=" + valor + ", caminhoImagem=" + caminhoImagem + "]";
	}
	
	

}
