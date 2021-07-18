package br.com.chacara.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.chacara.enums.TypeEventEnum;

public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nameClient;
	
	private String cellphone;
	
	private String cpf;
	
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

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
