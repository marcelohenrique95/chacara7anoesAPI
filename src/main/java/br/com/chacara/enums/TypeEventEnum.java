package br.com.chacara.enums;

public enum TypeEventEnum {

	Aniversario(1), Casamento(2), Churrasco(3), ChaDeBebe(4), Retiro(5), Familiar(6);

	private Integer eventId;

	TypeEventEnum(int eventId) {
		this.eventId = eventId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

}
