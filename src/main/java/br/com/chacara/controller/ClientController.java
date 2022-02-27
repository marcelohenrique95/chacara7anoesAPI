package br.com.chacara.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSender sendMail;

	public String sendMailWelcome(String email) {
		try {
			MimeMessage mail = sendMail.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom("contato.chacara7anoes@gmail.com");
			helper.setTo(email);
			helper.setSubject("Seja bem vindo");
			helper.setText("<p>Chacára 7 Anões - Espaço de Eventos</p>", true);
			
//			FileSystemResource file	      = new FileSystemResource(new File(pathToAttachment));
//			    helper.addAttachment("Invoice", file);
			sendMail.send(mail);

			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar e-mail";
		}
	}

}
