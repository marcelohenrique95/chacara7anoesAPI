package br.com.chacara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Client;
import br.com.chacara.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping(path = "/client")
	@ResponseStatus(HttpStatus.CREATED)
	public void regClient(@RequestBody Client client) {
		clientService.registerClient(client);
	}

	@GetMapping(path = "/client/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Client> listClient() {
		return clientService.listAll();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void removeClient(@RequestBody Client client) {
		clientService.removeClient(client);
	}

}
