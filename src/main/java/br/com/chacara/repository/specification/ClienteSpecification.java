package br.com.chacara.repository.specification;

import br.com.chacara.entity.Cliente;
import org.springframework.data.jpa.domain.Specification;

public class ClienteSpecification {

    public static Specification<Cliente> nomeEqual(String nome) {
        return (cliente, cq, cb) -> cb.equal(cliente.get("nome"), nome);
    }
}
