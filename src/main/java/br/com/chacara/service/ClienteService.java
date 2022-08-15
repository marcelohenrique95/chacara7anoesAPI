package br.com.chacara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	private static String CLIENTE_EMAIL_ERROR = "Usuário deve ter um email, por favor digite um email válido.";
	private static String CLIENTE_TELEFONE_ERROR = "O campo telefone não pode ser vázio, digite um número de contato válido.";
	private static String CLIENTE_NOME_ERROR = "O campo nome não pode ser vázio, digite seu nome completo.";

	public ResponseEntity<Cliente> createCliente(Cliente cliente) throws NegocioException {

		try {

			if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
				throw new NegocioException(CLIENTE_EMAIL_ERROR);
			}

			if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
				throw new NegocioException(CLIENTE_TELEFONE_ERROR);
			}

			if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
				throw new NegocioException(CLIENTE_NOME_ERROR);
			}

			sendEmail.sendMailWelcome(cliente);

			return ResponseEntity.ok(clienteRepository.save(cliente));
		} catch (NegocioException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	public void updateCliente(Long id, Cliente cliente) {
		Optional<Cliente> clienteDb = clienteRepository.findById(id);
		Cliente clienteUpdate = clienteDb.get();
		if (clienteUpdate != null) {
			clienteUpdate.setCpf(cliente.getCpf());
			clienteUpdate.setEndereco(cliente.getEndereco());
			clienteUpdate.setTelefone(cliente.getTelefone());
			clienteUpdate.setEmail(cliente.getEmail());

			clienteRepository.save(clienteUpdate);
		}
	}

	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}

	public void removeClient(Cliente cliente) {
		Optional<Cliente> clientExist = clienteRepository.findById(cliente.getId());
		if (clientExist != null) {
			clienteRepository.deleteById(cliente.getId());
		}
	}

}