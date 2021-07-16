package br.com.chacara.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.chacara.enums.TypeEventEnum;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String day;

	private TypeEventEnum typeEvent;

	private Integer qtdPerson;
	
	private Date dateReserve;

	private boolean tableGame;

	private double valuePerPerson;

	private double valuePerTypeEvent;

	private double valuePerDay;
	
	private double valueWithTables;

	private double valueFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isTableGame() {
		return tableGame;
	}

	public void setTableGame(boolean tableGame) {
		this.tableGame = tableGame;
	}

	public double getValuePerPerson() {
		return valuePerPerson;
	}

	public void setValuePerPerson(double valuePerPerson) {
		this.valuePerPerson = valuePerPerson;
	}

	public double getValuePerTypeEvent() {
		return valuePerTypeEvent;
	}

	public void setValuePerTypeEvent(double valuePerTypeEvent) {
		this.valuePerTypeEvent = valuePerTypeEvent;
	}

	public double getValueFinal() {
		return valueFinal;
	}

	public void setValueFinal(double valueFinal) {
		this.valueFinal = valueFinal;
	}

	public double getValuePerDay() {
		return valuePerDay;
	}

	public void setValuePerDay(double valuePerDay) {
		this.valuePerDay = valuePerDay;
	}

	public double getValueWithTables() {
		return valueWithTables;
	}

	public void setValueWithTables(double valueWithTables) {
		this.valueWithTables = valueWithTables;
	}

	public Date getDateReserve() {
		return dateReserve;
	}

	public void setDateReserve(Date dateReserve) {
		this.dateReserve = dateReserve;
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

}
