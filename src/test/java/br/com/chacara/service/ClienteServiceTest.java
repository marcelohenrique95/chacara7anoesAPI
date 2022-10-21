package br.com.chacara.service;

import br.com.chacara.entity.Cliente;
import br.com.chacara.repository.ClienteRepository;
import org.apache.coyote.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@WebAppConfiguration
public class ClienteServiceTest {

    @Mock
    private ClienteService service;

    @Mock
    private ClienteRepository repository;

    private Cliente cliente;

    private ResponseEntity responseCreated = new ResponseEntity(HttpStatus.CREATED);

    @BeforeEach
    void setUp() {
        startCliente();
    }

    @Test
    public void findClienteByIdSuccessTest() {
        when(service.findClienteById(anyLong())).thenReturn(Optional.ofNullable(cliente));
        Optional<Cliente> clienteService = service.findClienteById(123L);

        assertEquals("nome test", clienteService.get().getNome());
    }

    @Test
    public void createClienteSuccessTest() {
        when(service.createCliente(cliente)).thenReturn(responseCreated);
        ResponseEntity response = service.createCliente(cliente);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    public void listaAllClienteSuccessTest() {
        List<Cliente> list = new ArrayList<>();
        list.add(cliente);
        when(service.listAll()).thenReturn(list);
        List<Cliente> clienteList = service.listAll();

        assertEquals(1, clienteList.size());
        assertEquals(123L, clienteList.get(0).getId());
    }

    private void startCliente() {
        cliente = new Cliente();
        cliente.setId(123L);
        cliente.setNome("nome test");
        cliente.setEmail("email@teste");
        cliente.setCpf(1251325151L);
        cliente.setTelefone("Telefone test");
        cliente.setEndereco(null);
        cliente.setReserva(null);
    }
}
