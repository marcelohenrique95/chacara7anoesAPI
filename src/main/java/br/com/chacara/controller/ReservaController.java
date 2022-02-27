package br.com.chacara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Reserva;
import br.com.chacara.service.ReservaService;

@RestController
@RequestMapping("/v1/reserva")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public void reserva(@RequestBody Reserva reserva) {
		reservaService.reservar(reserva);
	}

	@GetMapping(path = "/client/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Reserva> listClient() {
		return reservaService.listAll();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void removeClient(@RequestBody Reserva reserva) {
		reservaService.removeReserva(reserva);
	}
}
