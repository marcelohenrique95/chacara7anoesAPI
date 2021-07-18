package br.com.chacara.enums;

public enum DayEnum {

	SEXTA(1), SABADO(2), DOMINGO(3), FERIADO(4), SEXSAB(5), SABDOM(6), SEXSABDOM(7), CARNAVAL(8), NATAL(9),
	REVEILLON(10), OUTRO(0);

	private Integer dayId;

	DayEnum(int dayId) {
		this.dayId = dayId;
	}

	public Integer getDayId() {
		return dayId;
	}

	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

}
