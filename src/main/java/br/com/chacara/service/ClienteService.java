package br.com.chacara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.controller.SendEmailController;
import br.com.chacara.entity.Cliente;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private SendEmailController sendEmail;

	public void registerCliente(Cliente client) {

		if (client.getEmail() == null || client.getEmail().isEmpty()) {
			throw new NegocioException("Por favor, digite um email.");
		}

		if (client.getTelefone() == null || client.getTelefone().isEmpty()) {
			throw new NegocioException("O campo celular não pode ser vázio, digite um número para contato.");
		}

		if (client.getNome() == null || client.getNome().isEmpty()) {
			throw new NegocioException("O campo nome não pode ser vazio, digite seu nome.");
		}
		
		sendEmail.sendMailWelcome(client);
		clienteRepository.save(client);

	}
	
	public void updateCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteUpdate = clienteRepository.findById(id);
		if(clienteUpdate != null) {
			
		}
	}

	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}

	public void removeClient(Cliente client) {
		Optional<Cliente> clientExist = clienteRepository.findById(client.getId());
		if (clientExist != null) {
			clienteRepository.deleteById(client.getId());
		}
	}

}