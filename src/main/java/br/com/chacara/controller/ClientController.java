package br.com.chacara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Client;
import br.com.chacara.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void regClient(@RequestBody Client client) {
		clientService.registerClient(client);
	}

}
