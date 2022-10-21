package br.com.chacara.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import br.com.chacara.enums.SimNaoEnum;
import br.com.chacara.enums.TypeEventEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tp_evento")
	private TypeEventEnum tpEvento;

	@Column(name = "qtd_convidados")
	private Long convidados;

	@Column(name = "dt_entrada")
	private Date dataEntrada;

	@Column(name = "dt_saida")
	private Date dataSaida;

	@Column(name = "situacao")
	private Integer situacao;

	@Column(name = "valor")
	private Long valor;

	@Column(name = "som_automotivo")
	@Enumerated(EnumType.STRING)
	private SimNaoEnum somAutomotivo;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

}
