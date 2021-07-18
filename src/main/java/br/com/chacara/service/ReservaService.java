package br.com.chacara.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.entity.Orcamento;
import br.com.chacara.entity.Reserva;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	public void reservar(Reserva reserva) {
		
		if(reserva == null) {
			throw new NegocioException("ERRO");
		}
		Optional<Reserva> reservaExist = reservaRepository.findById(reserva.getId());
		
		if(reservaExist != null) {
			throw new NegocioException("Você já reservou.");
		}
		
		if(reserva.getNameClient() == null || reserva.getNameClient().isEmpty()) {
			throw new NegocioException("Digite um nome.");
		}
		
		if(reserva.getConvidados() == null || reserva.getConvidados() == 0) {
			throw new NegocioException("Informe o número de convidados.");
		}
		
		if(reserva.getCellphone() == null || reserva.getCellphone().isEmpty()) {
			throw new NegocioException("Informe um telefone para contato.");
		}
		if(reserva.getTypeEvent() == null) {
			throw new NegocioException("Informe o tipo de evento.");
		} else {
			
		}
	}
	
	public void verifyTypeEvent(Reserva reserva) {

		if (reserva.getTypeEvent().getEventId() == 1 || reserva.getTypeEvent().getEventId() == 4
				|| reserva.getTypeEvent().getEventId() == 0) {
			reserva.setValuePerTypeEvent(200.0);
		}

		if (reserva.getTypeEvent().getEventId() == 2 || reserva.getTypeEvent().getEventId() == 6) {
			reserva.setValuePerTypeEvent(300.0);
		}

		if (reserva.getTypeEvent().getEventId() == 3 || reserva.getTypeEvent().getEventId() == 5) {
			reserva.setValuePerTypeEvent(100.0);
		}

		reserva.setValueFinal(reserva.getValuePerTypeEvent());

	}
	
	public void verifyInvited(Reserva reserva) {
		if (reserva.getConvidados() > 50) {
			reserva.setValuePerPerson(150.0);
		} else {
			reserva.setValuePerPerson(100.0);
		}

		reserva.setValueFinal(reserva.getValuePerPerson());

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
