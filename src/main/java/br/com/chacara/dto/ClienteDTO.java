package br.com.chacara.dto;

import br.com.chacara.entity.Endereco;
import br.com.chacara.entity.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private Long cpf;
    private String telefone;
    private String email;
    private Endereco endereco;
    private List<Reserva> reserva;
}
