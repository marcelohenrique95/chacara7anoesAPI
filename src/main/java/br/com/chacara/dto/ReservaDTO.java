package br.com.chacara.dto;

import br.com.chacara.entity.Cliente;
import br.com.chacara.enums.SimNaoEnum;
import br.com.chacara.enums.TypeEventEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ReservaDTO {

    private Long id;
    private TypeEventEnum tpEvento;
    private Long convidados;
    private Date dataEntrada;
    private Date dataSaida;
    private Integer situacao;
    private Long valor;
    private SimNaoEnum somAutomotivo;
    private Cliente cliente;

}
