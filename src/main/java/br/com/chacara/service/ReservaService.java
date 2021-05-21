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
	private ReservaRepository reservaRepo;
	
	public Reserva reserveDate(Reserva reserva) {
		Optional<Reserva> reserveExist = reservaRepo.findById(reserva.getId());
		
		if(reserveExist != null && reserveExist.equals(reserva.getId())) {
			throw new NegocioException("Já existe uma reserva.");
		}
		
		if(reserva.getData() == null) {
			throw new NegocioException("Preencha uma data válida");
		}
		
		if(reserva.getNameEvent() == null || reserva.getNameEvent().isEmpty()) {
			throw new NegocioException("Preencha o nome do evento.");
		}
		
		if(reserva.getTypeEvent() == null) {
			throw new NegocioException("Selecione o tipo de evento.");
		}
		
		if(reserva.getQtdPerson() == null) {
			throw new NegocioException("Diga a quantidade de pessoas !");
		}
		if(reserva.getQtdPerson() <= 95) {
			throw new NegocioException("Espaço não suporta essa quantidade de pessoas, desculpe..");
		}
		
		if(reserva.getCliente().getName() == null || reserva.getCliente().getName().isEmpty()) {
			throw new NegocioException("Por favor, preencha seu nome !");
		}
		if(reserva.getCliente().getCellphone() == null || reserva.getCliente().getCellphone().isEmpty()) {
			throw new NegocioException("Por favor, preencha seu celular !");
		}
		
		return reservaRepo.save(reserva);
	}
	
	public List<Reserva> listReserve(){
		return reservaRepo.findAll();
	}

}
