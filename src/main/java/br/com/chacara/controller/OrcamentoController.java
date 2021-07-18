package br.com.chacara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.chacara.entity.Orcamento;
import br.com.chacara.service.OrcamentoService;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {

	@Autowired
	private OrcamentoService orcamentoService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	public String getPrice(@RequestBody Orcamento orcamento) {
		return orcamentoService.getOrcamento(orcamento);
	}

}
