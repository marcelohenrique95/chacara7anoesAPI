package br.com.chacara.repository.specification;

import br.com.chacara.entity.Reserva;
import br.com.chacara.enums.TypeEventEnum;
import org.springframework.data.jpa.domain.Specification;

public class ReservaSpecification {

    public static Specification<Reserva> filterReserva(Reserva filtro) {
        Specification specs = (reserva, cq, cb) -> cb.conjunction();

        if (filtro.getSituacao() != null) {
            specs = specs.and(situacaoSpec(filtro.getSituacao()));
        }

        if (filtro.getTpEvento() != null) {
            specs = specs.and(tipoEventoSpec(filtro.getTpEvento()));
        }

        return specs;
    }

    public static Specification<Reserva> gratherThanConvidados(Long convidados) {
        return (reserva, cq, cb) -> cb.greaterThan(reserva.get("convidados"), convidados);
    }

    public static Specification<Reserva> lessThanConvidados(Long convidados) {
        return (reserva, cq, cb) -> cb.lessThan(reserva.get("convidados"), convidados);
    }

    public static Specification<Reserva> betweenConvidados(Long min, Long max) {
        return (reserva, cq, cb) -> cb.between(reserva.get("convidados"), min, max);
    }

    public static Specification<Reserva> greatherThanValor(Long valor) {
        return (reserva, cq, cb) -> cb.greaterThan(reserva.get("valor"), valor);
    }

    public static Specification<Reserva> lessThanValor(Long valor) {
        return (reserva, cq, cb) -> cb.lessThan(reserva.get("valor"), valor);
    }

    public static Specification<Reserva> betweenValor(Long min, Long max) {
        return (reserva, cq, cb) -> cb.between(reserva.get("valor"), min, max);
    }

    public static Specification<Reserva> situacaoSpec(Integer situacao) {
        return (reserva, cq, cb) -> cb.equal(reserva.get("situacao"), situacao);
    }

    public static Specification<Reserva> tipoEventoSpec(TypeEventEnum tpEvento) {
        return (reserva, cq, cb) -> cb.equal(reserva.get("tpEvento"), tpEvento);
    }
}
