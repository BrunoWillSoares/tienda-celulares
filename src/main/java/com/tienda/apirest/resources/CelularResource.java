package com.tienda.apirest.resources;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadopago.resources.Preference;
import com.tienda.business.CelularBusiness;
import com.tienda.business.CelularBuyBusiness;
import com.tienda.models.Celular;
import com.tienda.models.PaymentMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Celulares")
public class CelularResource {
	
	private static CelularBuyBusiness celularBuyBusiness = new CelularBuyBusiness();
	private static CelularBusiness celularBusiness = new CelularBusiness();
	
	
	  @ApiOperation(value="Returns all phones")
	  @CrossOrigin(origins = "*")
	  @GetMapping("/celulares") public List<Celular> listaCelulares(){ 
		  return celularBusiness.obterCelulares();
	  }
	  
	/*
	 * @ApiOperation(value="Returns a specific phone")
	 * 
	 * @GetMapping("/celular/{id}") public Celular
	 * listaCelularEspecifico(@PathVariable(value="id") long id){ return
	 * produtoRepository.findById(id); }
	 * 
	 * @ApiOperation(value="Creates a phone")
	 * 
	 * @PostMapping("/celular") public Celular criaCelular(@RequestBody @Valid
	 * Celular produto) { return produtoRepository.save(produto); }
	 * 
	 * @ApiOperation(value="Deletes a phone")
	 * 
	 * @DeleteMapping("/celular") public void deletaCelular(@RequestBody @Valid
	 * Celular produto) { produtoRepository.delete(produto); }
	 * 
	 * @ApiOperation(value="Update a phone")
	 * 
	 * @PutMapping("/celular") public Celular atualizaCelular(@RequestBody @Valid
	 * Celular produto) { return produtoRepository.save(produto); }
	 */ 
	/*
	 * 401 Unauthorized
	 * 
	 * 403 Forbidden
	 */	
	@ApiOperation(value="Return Payment Methods")
	@GetMapping("/celular/buy/payments")
	public List<PaymentMethod> obterFormasPagamento() {
		return celularBuyBusiness.obterFormasPagamento();
	}
	
	@ApiOperation(value="Prepare buy process")
	@GetMapping("/celular/buy")
	public Preference comprar(@RequestBody Celular celular) {
		return celularBuyBusiness.comprar(celular);
	}

}
