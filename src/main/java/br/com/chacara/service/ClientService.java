package br.com.chacara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.entity.Client;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public void registerClient(Client client) {
		
		if(client.getEmail() == null || client.getEmail().isEmpty()) {
			throw new NegocioException("Por favor, digite um email.");
		}
		
		Client clientExist = (Client) clientRepository.findByEmail(client.getEmail());
		
		if(clientExist != null) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email.");
		}
		
		if(client.getCellphone() == null || client.getCellphone().isEmpty()) {
			throw new NegocioException("O campo celular não pode ser vázio, digite o numero para contato.");
		}
		
		if(client.getName() == null || client.getName().isEmpty()) {
			throw new NegocioException("O campo nome não pode ser vazio, digite seu nome.");
		}
		
		clientRepository.save(client);
		
	}
	
	public List<Client> listAll(){
		return (List<Client>) clientRepository.findAll();
	}

}