package br.com.chacara.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.chacara.enums.DayEnum;

@Entity
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private DayEnum dayEnum;

	private boolean coupon;

	private double valuePerPerson;

	private double valuePerTypeEvent;

	private double valuePerDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	public DayEnum getDayEnum() {
		return dayEnum;
	}

	public void setDayEnum(DayEnum dayEnum) {
		this.dayEnum = dayEnum;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Orcamento other = (Orcamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
