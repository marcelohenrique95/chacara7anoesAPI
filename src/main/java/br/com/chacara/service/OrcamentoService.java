package br.com.chacara.service;

import org.springframework.stereotype.Service;

import br.com.chacara.entity.Orcamento;
import br.com.chacara.enums.DayEnum;
import br.com.chacara.enums.TypeEventEnum;
import br.com.chacara.exception.NegocioException;

@Service
public class OrcamentoService {

	Double totalValueEvent;

	private static Double VALOR_CUPOM = 90.0;

	private static Double VALOR_SEXTA_DOMINGO = 300.0;

	private static Double VALOR_SABADO_FERIADO = 450.0;

	private static Double VALOR_DOIS_DIAS = 700.0;

	private static Double VALOR_TRES_DIAS = 900.0;

	private static Double VALOR_BIG_FERIADOS = 2500.0;

	public String getOrcamento(Integer diaId, Integer eventId, Integer conv, boolean coupon) {
		Orcamento orcamento = new Orcamento();

		if (diaId == null || eventId == null || conv == null) {
			throw new NegocioException("Preencha todos os campos.");
		}

		orcamento.setValuePerDay(verifyDay(diaId));
		orcamento.setValuePerTypeEvent(verifyTypeEvent(eventId));
		orcamento.setValuePerPerson(verifyQtdPerson(conv));

		totalValueEvent = calculateTotalValue(orcamento);

		if (coupon) {
			return totalWithCoupon(totalValueEvent);
		}
		System.out.println(totalValueEvent.toString());
		return totalValueEvent.toString();
	}

	public Double verifyTypeEvent(Integer eventId) {

		if (eventId == TypeEventEnum.Aniversario.getEventId() || eventId == TypeEventEnum.ChaDeBebe.getEventId()) {
			return 200.0;
		}

		if (eventId == TypeEventEnum.Casamento.getEventId() || eventId == TypeEventEnum.Retiro.getEventId()) {
			return 300.0;
		}
		return 100.0;
	}

	public Double verifyQtdPerson(Integer qtdConv) {
		Double taxaConvidado = 120.0;
		if (qtdConv <= 20) {
			taxaConvidado = 50.0;
		} else if (qtdConv <= 50) {
			taxaConvidado = 70.0;
		}

		return taxaConvidado;
	}

	public Double verifyDay(Integer diaId) {

		if (diaId == DayEnum.SEXTA.getDayId() || diaId == DayEnum.DOMINGO.getDayId()) {
			return VALOR_SEXTA_DOMINGO;
		}

		if (diaId == DayEnum.SABADO.getDayId() || diaId == DayEnum.FERIADO.getDayId()) {
			return VALOR_SABADO_FERIADO;
		}

		if (diaId == DayEnum.SEXSAB.getDayId() || diaId == DayEnum.SABDOM.getDayId()) {
			return VALOR_DOIS_DIAS;
		}

		if (diaId == DayEnum.SEXSABDOM.getDayId()) {
			return VALOR_TRES_DIAS;
		}

		if (diaId == DayEnum.CARNAVAL.getDayId() || diaId == DayEnum.NATAL.getDayId()
				|| diaId == DayEnum.REVEILLON.getDayId()) {
			return VALOR_BIG_FERIADOS;
		}

		return 200.0;

	}

	public Double calculateTotalValue(Orcamento orcamento) {
		Double totalValue = orcamento.getValuePerDay() + orcamento.getValuePerPerson()
				+ orcamento.getValuePerTypeEvent();
		return totalValue;
	}

	public String totalWithCoupon(Double value) {
		value = value - VALOR_CUPOM;
		return value.toString();
	}

}
