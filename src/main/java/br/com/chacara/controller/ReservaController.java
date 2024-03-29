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
	private ReservaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public void reserva(@RequestBody Reserva reserva) {
		service.reservar(reserva);
	}

	@GetMapping(path = "/list-all")
	@ResponseStatus(HttpStatus.OK)
	public List<Reserva> listClient() {
		return service.listAll();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void removeClient(@RequestBody Reserva reserva) {
		service.removeReserva(reserva);
	}
}
