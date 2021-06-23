package br.com.chacara.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.chacara.enums.TypeEventEnum;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String day;
	
	private double hour;
	
	private double value;
	
	private TypeEventEnum typeEvent;
	
	private Integer qtdPerson;
	
	private boolean tableGame;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtdPerson == null) ? 0 : qtdPerson.hashCode());
		result = prime * result + ((typeEvent == null) ? 0 : typeEvent.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtdPerson == null) {
			if (other.qtdPerson != null)
				return false;
		} else if (!qtdPerson.equals(other.qtdPerson))
			return false;
		return true;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

	public boolean isTableGame() {
		return tableGame;
	}

	public void setTableGame(boolean tableGame) {
		this.tableGame = tableGame;
	}

}
