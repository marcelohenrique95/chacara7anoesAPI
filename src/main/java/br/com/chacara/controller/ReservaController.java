package br.com.chacara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Reserva;
import br.com.chacara.service.ReservaService;

@RestController
@RequestMapping("/reserve")
public class ReservaController {

	@Autowired
	private ReservaService reservaServ;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva registerReserve(@RequestBody Reserva reserva) {
		return reservaServ.reserveDate(reserva);
	}

	@GetMapping(path = "/listReserve")
	public List<Reserva> listAll() {
		return reservaServ.listReserve();
	}

}
