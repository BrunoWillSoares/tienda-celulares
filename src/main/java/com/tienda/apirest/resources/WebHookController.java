package com.tienda.apirest.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebHookController {
	
	@PostMapping
	public ResponseEntity<String> print(@RequestBody String json) {
		System.out.println("Webhook acionado... ");
		System.out.println("JSON: " + json);
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

}
