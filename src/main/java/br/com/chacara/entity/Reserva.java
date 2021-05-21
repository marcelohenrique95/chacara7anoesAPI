package br.com.chacara.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.chacara.enums.TypeEventEnum;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nameEvent;
	
	private String value;
	
	private Date data;
	
	private TypeEventEnum typeEvent;
	
	private Integer qtdPerson;
	
	@ManyToOne
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Integer getQtdPerson() {
		return qtdPerson;
	}

	public void setQtdPerson(Integer qtdPerson) {
		this.qtdPerson = qtdPerson;
	}

	public TypeEventEnum getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(TypeEventEnum typeEvent) {
		this.typeEvent = typeEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nameEvent == null) ? 0 : nameEvent.hashCode());
		result = prime * result + ((qtdPerson == null) ? 0 : qtdPerson.hashCode());
		result = prime * result + ((typeEvent == null) ? 0 : typeEvent.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
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
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nameEvent == null) {
			if (other.nameEvent != null)
				return false;
		} else if (!nameEvent.equals(other.nameEvent))
			return false;
		if (qtdPerson == null) {
			if (other.qtdPerson != null)
				return false;
		} else if (!qtdPerson.equals(other.qtdPerson))
			return false;
		if (typeEvent != other.typeEvent)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
