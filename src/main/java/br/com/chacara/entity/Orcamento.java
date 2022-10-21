package br.com.chacara.entity;

import br.com.chacara.enums.DayEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private DayEnum dayEnum;

	private boolean coupon;

	private double valuePerPerson;

	private double valuePerTypeEvent;

	private double valuePerDay;
}
