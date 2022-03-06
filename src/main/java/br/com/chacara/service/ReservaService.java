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

	public void reservar(Reserva reserva) {

		if (reserva == null) {
			throw new NegocioException("ERRO");
		}
		Optional<Reserva> reservaExist = reservaRepository.findById(reserva.getId());

		if (reservaExist != null) {
			throw new NegocioException("Você já reservou.");
		}

		if (reserva.getClient().getName() == null || reserva.getClient().getName().isEmpty()) {
			throw new NegocioException("Digite um nome.");
		}

		if (reserva.getInvited() == null || reserva.getInvited() == 0) {
			throw new NegocioException("Informe o número de convidados.");
		}

		if (reserva.getClient().getCellphone() == null || reserva.getClient().getCellphone().isEmpty()) {
			throw new NegocioException("Informe um telefone para contato.");
		}
		if (reserva.getTypeEvent() == null) {
			throw new NegocioException("Informe o tipo de evento.");
		}

		reservaRepository.save(reserva);
	}

	public List<Reserva> listAll() {
		return reservaRepository.findAll();
	}

	public void removeReserva(Reserva reserva) {
		Optional<Reserva> reservaExist = reservaRepository.findById(reserva.getId());
		if (reservaExist != null) {
			reservaRepository.deleteById(reserva.getId());
		}
	}

}
