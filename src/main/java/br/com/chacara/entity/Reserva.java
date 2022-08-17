package br.com.chacara.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import br.com.chacara.enums.SimNaoEnum;
import br.com.chacara.enums.TypeEventEnum;

@Entity
@Table(name = "reserva")
public class Reserva {

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeEventEnum getTpEvento() {
		return tpEvento;
	}

	public void setTpEvento(TypeEventEnum tpEvento) {
		this.tpEvento = tpEvento;
	}

	public Long getConvidados() {
		return convidados;
	}

	public void setConvidados(Long convidados) {
		this.convidados = convidados;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public SimNaoEnum getSomAutomotivo() {
		return somAutomotivo;
	}

	public void setSomAutomotivo(SimNaoEnum somAutomotivo) {
		this.somAutomotivo = somAutomotivo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
