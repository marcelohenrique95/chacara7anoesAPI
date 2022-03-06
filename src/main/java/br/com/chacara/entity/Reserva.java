package br.com.chacara.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.chacara.enums.TypeEventEnum;

@Entity
@Table(name = "reserva")
public class Reserva extends Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tipo_evento")
	private TypeEventEnum typeEvent;

	@Column(name = "qtd_convidados")
	private Integer invited;

	@Column(name = "dt_evento")
	private Date data;

	@Column(name = "valor_total")
	private double valueFinal;

	@Column(name = "client_id")
	private Long client_id;

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}

	public Integer getInvited() {
		return invited;
	}

	public void setInvited(Integer invited) {
		this.invited = invited;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeEventEnum getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(TypeEventEnum typeEvent) {
		this.typeEvent = typeEvent;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValueFinal() {
		return valueFinal;
	}

	public void setValueFinal(double valueFinal) {
		this.valueFinal = valueFinal;
	}

}
