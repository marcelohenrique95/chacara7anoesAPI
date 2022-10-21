package br.com.chacara.controller;

import java.util.List;

import br.com.chacara.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Cliente;
import br.com.chacara.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> regClient(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}

	@GetMapping(path = "/list-all")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listClient() {

		return clienteService.listAll();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void removeClient(@RequestBody Cliente cliente) {
		clienteService.removeClient(cliente);
	}

}
