package br.com.chacara.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.chacara.enums.TypeEventEnum;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_evento")
	private TypeEventEnum typeEvent;

	@Column(name = "qtd_convidados")
	private Integer invited;

	@Column(name = "dt_evento")
	private Date data;

	@Column(name = "valor_total")
	private double valueFinal;

	@ManyToOne
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(client, data, id, invited, typeEvent, valueFinal);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(client, other.client) && Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(invited, other.invited) && typeEvent == other.typeEvent
				&& Double.doubleToLongBits(valueFinal) == Double.doubleToLongBits(other.valueFinal);
	}

}
