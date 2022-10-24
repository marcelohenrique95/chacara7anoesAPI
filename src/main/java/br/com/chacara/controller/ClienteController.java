package br.com.chacara.controller;

import br.com.chacara.entity.Cliente;
import br.com.chacara.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> regClient(@RequestBody Cliente cliente) {
        return service.createCliente(cliente);
    }

    @GetMapping(path = "/list-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listClient() {

        return service.listAll();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeClient(@RequestBody Cliente cliente) {
        service.removeClient(cliente);
    }

}
