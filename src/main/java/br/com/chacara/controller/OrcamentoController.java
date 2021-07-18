package br.com.chacara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.service.OrcamentoService;

@RestController
@RequestMapping("/v1/orcamento")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@PostMapping(path = "/{diaId}/{eventoId}/{conv}")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public String getOrcamento(@PathVariable("diaId") Integer diaId, @PathVariable("eventoId") Integer eventoId, @PathVariable("conv") Integer conv) {
		return orcamentoService.getOrcamento(diaId, eventoId, conv);
	}

}
