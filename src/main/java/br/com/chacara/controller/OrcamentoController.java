package br.com.chacara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.service.OrcamentoService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@GetMapping(path = "/orcamento/{diaId}/{eventoId}/{conv}/{coupon}")
	@ResponseStatus(HttpStatus.OK)
	public String getOrcamento(@PathVariable("diaId") Integer diaId, @PathVariable("eventoId") Integer eventoId,
			@PathVariable("conv") Integer conv, @PathVariable("coupon") boolean coupon) {
		return orcamentoService.getOrcamento(diaId, eventoId, conv, coupon);
	}

}
