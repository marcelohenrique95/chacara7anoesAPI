package br.com.chacara.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Cliente;
import br.com.chacara.entity.Reserva;

@CrossOrigin
@RestController
public class SendEmailController {

	@Autowired
	private JavaMailSender sendMail;

	public String sendMailWelcome(Cliente client) {
		try {
			MimeMessage mail = sendMail.createMimeMessage();

			System.out.println("entrou no metodo send");
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo(client.getEmail());
			helper.setSubject(
					"Seja bem vindo " + client.getNome().substring(0, client.getNome().indexOf(" ")).concat(" !"));
			helper.setText("<h1 style='color: #74d455'>Chacára 7 Anões - Espaço de Eventos</h1>" + "<br>"
					+ "<p>Olá <strong style='color: #db8437'>"
					+ client.getNome().substring(0, client.getNome().indexOf(" ")).concat(" !")
					+ "</strong> Sua conta foi criada com SUCESSO !</p>" + "<br><br>" + "<hr/>"
					+ "<p>Jardim Universitário, Cuiabá-MT | (65) 98123-4218 </p>"
					+ "<a href='https://www.instagram.com/chacara7anoes/'>Nos siga no Instagram</a>", true);

//			FileSystemResource file	      = new FileSystemResource(new File(pathToAttachment));
//			    helper.addAttachment("Invoice", file);
			sendMail.send(mail);

			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar e-mail";
		}
	}

	public String sendMailContract(Reserva reserva) {
		try {
			MimeMessage mail = sendMail.createMimeMessage();

			System.out.println("entrou no metodo send");
			MimeMessageHelper helper = new MimeMessageHelper(mail);
//			helper.setTo(reserva.getPessoa().getEmail());
//			helper.setSubject("Olá " + reserva.getPessoa().getNome().substring(0, reserva.getPessoa().getNome().indexOf(" ")).concat(" !"));
			helper.setText("<h1 style='color: #74d455'>Chacára 7 Anões - Espaço de Eventos</h1>" + "<br>" +
			"", true);
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar e-mail";
		}
	}

}
