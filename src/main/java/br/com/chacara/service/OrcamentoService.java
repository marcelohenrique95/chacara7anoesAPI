package br.com.chacara.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.entity.Orcamento;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.OrcamentoRepository;

@Service
public class OrcamentoService {

	@Autowired
	private OrcamentoRepository orcamentoRepository;
	String resposta;

	public String getOrcamento(Orcamento orcamento) {
		Optional<Orcamento> reserveExist = orcamentoRepository.findById(orcamento.getId());

		if (reserveExist != null && reserveExist.equals(orcamento.getId())) {
			throw new NegocioException("Já existe uma reserva.");
		}

		if (orcamento.getTypeEvent() == null) {
			throw new NegocioException("Selecione o tipo de evento.");
		} else {
			verifyTypeEvent(orcamento);
		}

		if (orcamento.getQtdPerson() == null || orcamento.getQtdPerson() == 0) {
			throw new NegocioException("Diga a quantidade de pessoas !");
		} else if (orcamento.getQtdPerson() > 95) {
			throw new NegocioException("Espaço não suporta essa quantidade !");
		} else {
			verifyQtdPerson(orcamento);
		}

		if (orcamento.getDayEnum().getDayId() == null) {
			throw new NegocioException("Selecione o dia do evento !");
		} else {
			verifyDay(orcamento);
		}

		System.out.println("Valor total do evento: " + orcamento.getValueFinal());
		System.out.println("Seu evento será um " + orcamento.getTypeEvent() + ", no dia " + orcamento.getDayEnum()
				+ "para" + orcamento.getQtdPerson() + " pessoas.");
		
		resposta = "O valor do seu evento será" + orcamento.getValueFinal();
		
		return resposta;
	}

	public void verifyTypeEvent(Orcamento orcamento) {

		if (orcamento.getTypeEvent().getEventId() == 1 || orcamento.getTypeEvent().getEventId() == 4
				|| orcamento.getTypeEvent().getEventId() == 0) {
			orcamento.setValuePerTypeEvent(200.0);
		}

		if (orcamento.getTypeEvent().getEventId() == 2 || orcamento.getTypeEvent().getEventId() == 6) {
			orcamento.setValuePerTypeEvent(300.0);
		}

		if (orcamento.getTypeEvent().getEventId() == 3 || orcamento.getTypeEvent().getEventId() == 5) {
			orcamento.setValuePerTypeEvent(100.0);
		}

		orcamento.setValueFinal(orcamento.getValuePerTypeEvent());

	}

	public void verifyQtdPerson(Orcamento orcamento) {
		if (orcamento.getQtdPerson() > 50) {
			orcamento.setValuePerPerson(150.0);
		} else {
			orcamento.setValuePerPerson(100.0);
		}

		orcamento.setValueFinal(orcamento.getValuePerPerson());

	}

	public void verifyDay(Orcamento orcamento) {

		if (orcamento.getDayEnum().getDayId() == 1 || orcamento.getDayEnum().getDayId() == 3) {
			orcamento.setValuePerDay(300.0);
		}

		if (orcamento.getDayEnum().getDayId() == 2 || orcamento.getDayEnum().getDayId() == 4) {
			orcamento.setValuePerDay(450.0);
		}

		if (orcamento.getDayEnum().getDayId() == 5 || orcamento.getDayEnum().getDayId() == 6) {
			orcamento.setValuePerDay(700.0);
		}

		if (orcamento.getDayEnum().getDayId() == 7) {
			orcamento.setValuePerDay(900.0);
		}

		if (orcamento.getDayEnum().getDayId() == 8 || orcamento.getDayEnum().getDayId() == 9
				|| orcamento.getDayEnum().getDayId() == 10) {
			orcamento.setValuePerDay(2500.0);
		}
		orcamento.setValueFinal(orcamento.getValuePerDay());

	}

}
