package br.com.chacara.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.chacara.enums.TypeEventEnum;

@Entity
public class Reserva extends Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private TypeEventEnum typeEvent;
	
	private Integer convidados;
	
	private Date data;
	
	private double valuePerPerson;

	private double valuePerTypeEvent;

	private double valuePerDay;

	private double valueFinal;

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

	public Integer getConvidados() {
		return convidados;
	}

	public void setConvidados(Integer convidados) {
		this.convidados = convidados;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public double getValuePerDay() {
		return valuePerDay;
	}

	public void setValuePerDay(double valuePerDay) {
		this.valuePerDay = valuePerDay;
	}

	public double getValueFinal() {
		return valueFinal;
	}

	public void setValueFinal(double valueFinal) {
		this.valueFinal = valueFinal;
	}
	
	

}
