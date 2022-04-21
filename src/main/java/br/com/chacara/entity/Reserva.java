package br.com.chacara.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.chacara.enums.TypeEventEnum;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "cpf_cliente")
	private Long cpfCliente;

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

	public Long getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(convidados, dataEntrada, dataSaida, id, cpfCliente, situacao, tpEvento, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(convidados, other.convidados) && Objects.equals(dataEntrada, other.dataEntrada)
				&& Objects.equals(dataSaida, other.dataSaida) && Objects.equals(id, other.id)
				&& Objects.equals(cpfCliente, other.cpfCliente) && Objects.equals(situacao, other.situacao)
				&& tpEvento == other.tpEvento && Objects.equals(valor, other.valor);
	}

}
