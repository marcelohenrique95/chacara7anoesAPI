package br.com.chacara.service;

import org.springframework.stereotype.Service;

import br.com.chacara.entity.Orcamento;
import br.com.chacara.enums.DayEnum;
import br.com.chacara.enums.TypeEventEnum;
import br.com.chacara.exception.NegocioException;

@Service
public class OrcamentoService {

	String resposta;
	Double total;

	public String getOrcamento(Integer diaId, Integer eventId, Integer conv) {
		Orcamento orcamento = new Orcamento();
				
		if(diaId == null || eventId == null || conv == null) {
			throw new NegocioException("Preencha todos os campos.");
		}		
		verifyDay(orcamento, diaId);
        verifyTypeEvent(orcamento, eventId);      
        verifyQtdPerson(orcamento, conv);
        
        total = orcamento.getValuePerDay() + orcamento.getValuePerPerson() + orcamento.getValuePerTypeEvent();
        orcamento.setValueFinal(total);
		
		resposta = "O valor do seu evento será R$" + orcamento.getValueFinal();
		
		System.out.println(resposta);
		return resposta;
	}

	public void verifyTypeEvent(Orcamento orcamento, Integer eventId) {

		if (eventId == TypeEventEnum.Aniversario.getEventId() || eventId == TypeEventEnum.ChaDeBebe.getEventId()) {
			orcamento.setValuePerTypeEvent(200.0);
		}

		if (eventId == TypeEventEnum.Casamento.getEventId() || eventId == TypeEventEnum.Retiro.getEventId()) {
			orcamento.setValuePerTypeEvent(300.0);
		}

		if (eventId == TypeEventEnum.Churrasco.getEventId() || eventId == TypeEventEnum.Familiar.getEventId()) {
			orcamento.setValuePerTypeEvent(100.0);
		}

	}

	public void verifyQtdPerson(Orcamento orcamento, Integer conv) {
		if(conv <= 20) {
			orcamento.setValuePerPerson(50.0);
		} else if (conv <= 50) {
			orcamento.setValuePerPerson(70.0);
		} else {
			orcamento.setValuePerPerson(120.0);
		}

	}

	public void verifyDay(Orcamento orcamento, Integer diaId) {

		if (diaId == DayEnum.SEXTA.getDayId() || diaId == DayEnum.DOMINGO.getDayId()) {
			orcamento.setValuePerDay(300.0);
		}

		if (diaId == DayEnum.SABADO.getDayId() || diaId == DayEnum.FERIADO.getDayId()) {
			orcamento.setValuePerDay(450.0);
		}

		if (diaId == DayEnum.SEXSAB.getDayId() || diaId == DayEnum.SABDOM.getDayId()) {
			orcamento.setValuePerDay(700.0);
		}

		if (diaId == DayEnum.SEXSABDOM.getDayId()) {
			orcamento.setValuePerDay(900.0);
		}

		if (diaId == DayEnum.CARNAVAL.getDayId() || diaId == DayEnum.NATAL.getDayId() || diaId == DayEnum.REVEILLON.getDayId()) {
			orcamento.setValuePerDay(2500.0);
		}
		
		if (diaId == DayEnum.OUTRO.getDayId()) {
			orcamento.setValuePerDay(200.0);
		}
		

	}

}
