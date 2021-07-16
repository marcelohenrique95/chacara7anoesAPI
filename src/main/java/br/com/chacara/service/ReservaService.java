package br.com.chacara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.entity.Reserva;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	public double eventQuote(Reserva reserva) {
		Optional<Reserva> reserveExist = reservaRepository.findById(reserva.getId());

		if (reserveExist != null && reserveExist.equals(reserva.getId())) {
			throw new NegocioException("Já existe uma reserva.");
		}

		if (reserva.getTypeEvent() == null) {
			throw new NegocioException("Selecione o tipo de evento.");
		} else {
			verifyTypeEvent(reserva);
		}

		if (reserva.getQtdPerson() == null || reserva.getQtdPerson() == 0) {
			throw new NegocioException("Diga a quantidade de pessoas !");
		} else if (reserva.getQtdPerson() > 95) {
			throw new NegocioException("Espaço não suporta essa quantidade !");
		} else {
			verifyQtdPerson(reserva);
		}

		if (reserva.getDay() == null) {
			throw new NegocioException("Selecione o dia do evento !");
		} else {
			verifyDay(reserva);
		}

		if (reserva.isTableGame()) {
			reserva.setValueWithTables(50.0);
		}

		System.out.println("Valor total do evento: " + reserva.getValueFinal());
		System.out.println("Seu evento será um " + reserva.getTypeEvent() + ", no dia " 
		+ reserva.getDay() + "para" + reserva.getQtdPerson() + " pessoas.");
		return reserva.getValueFinal();
	}

	public List<Reserva> listReserve() {
		return (List<Reserva>) reservaRepository.findAll();
	}

	public void verifyTypeEvent(Reserva reserva) {

		if (reserva.getTypeEvent().getEventId() == 1 || reserva.getTypeEvent().getEventId() == 4
				|| reserva.getTypeEvent().getEventId() == 0) {
			reserva.setValuePerTypeEvent(600.0);
		}

		if (reserva.getTypeEvent().getEventId() == 2 || reserva.getTypeEvent().getEventId() == 6) {
			reserva.setValuePerTypeEvent(700.0);
		}

		if (reserva.getTypeEvent().getEventId() == 3 || reserva.getTypeEvent().getEventId() == 5) {
			reserva.setValuePerTypeEvent(500.0);
		}

		reserva.setValueFinal(reserva.getValuePerTypeEvent());

	}

	public void verifyQtdPerson(Reserva reserva) {
		if (reserva.getQtdPerson() > 50) {
			reserva.setValuePerPerson(150.0);
		} else {
			reserva.setValuePerPerson(100.0);
		}

		reserva.setValueFinal(reserva.getValuePerPerson());

	}

	public void verifyDay(Reserva reserva) {

		if (reserva.getDay() == "sex") {
			reserva.setValuePerDay(50.0);
		}

		if (reserva.getDay() == "sab") {
			reserva.setValuePerDay(150.0);
		}

		if (reserva.getDay() == "dom" || reserva.getDay() == "fer") {
			reserva.setValuePerDay(100.0);
		}
		
		if (reserva.getDay() == "sabdom") {
			reserva.setValuePerDay(230.0);
		}
		reserva.setValueFinal(reserva.getValuePerDay());

	}

}
