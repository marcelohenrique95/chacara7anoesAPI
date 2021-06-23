package br.com.chacara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.chacara.entity.Reserva;
import br.com.chacara.enums.TypeEventEnum;
import br.com.chacara.exception.NegocioException;
import br.com.chacara.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepo;
	
	private TypeEventEnum typeEvent;
	
	private double valueI = 1;
	private double valueII = 2;
	private double valueIII =3;
	private double valueIIIX = 30;
	private double valueV = 50;
	private double valueVII = 70;
	private double valueX = 100;
	private double valueXII = 120;
	private double valueXV = 150;
	private double valueXX = 200;
	private double valueXIV = 400;
	private double valueXVV = 550;

	public double eventQuote(Reserva reserva) {
		Optional<Reserva> reserveExist = reservaRepo.findById(reserva.getId());

		if (reserveExist != null && reserveExist.equals(reserva.getId())) {
			throw new NegocioException("Já existe uma reserva.");
		}

		if (reserva.getTypeEvent() == null) {
			throw new NegocioException("Selecione o tipo de evento.");
		}

		if (reserva.getQtdPerson() == null) {
			throw new NegocioException("Diga a quantidade de pessoas !");
		}
		
		if (reserva.getQtdPerson() <= 95) {
			throw new NegocioException("Espaço não suporta essa quantidade de pessoas, desculpe..");
		}

		if (reserva.getDay() == null) {
			throw new NegocioException("Selecione o dia do evento !");
		}
		if (reserva.getHour() > valueI) {
			throw new NegocioException("Selecione o horario do seu evento !");
		}
		
		if(reserva.getQtdPerson() < valueIIIX) {
			reserva.setValue(valueVII);
		} else {
			reserva.setValue(valueX);
		}
		
		if(reserva.isTableGame()) {
			reserva.setValue(valueV);
		}
		
		if(reserva.getTypeEvent() ==  typeEvent.Aniversario || reserva.getTypeEvent() == typeEvent.ChaDeBebe) {
			reserva.setValue(valueXIV);
		}
		
		if(reserva.getTypeEvent() == typeEvent.Casamento || reserva.getTypeEvent() == typeEvent.Retiro) {
			reserva.setValue(valueXVV);
		}
		
		if(reserva.getHour() == valueI || reserva.getHour() == valueIII) {
			reserva.setValue(valueXV);
		}
		
		if(reserva.getDay() == "sex" || reserva.getDay() == "sab" || reserva.getDay() == "dom" || reserva.getDay() == "fer") {
			reserva.setValue(valueXII);
		} else {
			reserva.setValue(valueXIV);
		}

		return reserva.getValue();
	}

	public List<Reserva> listReserve() {
		return reservaRepo.findAll();
	}

}
