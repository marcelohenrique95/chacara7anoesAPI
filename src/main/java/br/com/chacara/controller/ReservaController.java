package br.com.chacara.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	private ReservaService reservaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public double getPrice(@RequestBody Reserva reserva) {
		return reservaService.eventQuote(reserva);
	}

	@GetMapping(path = "/listReserve")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public List<Reserva> listAll() {
		return reservaService.listReserve();
	}

}
