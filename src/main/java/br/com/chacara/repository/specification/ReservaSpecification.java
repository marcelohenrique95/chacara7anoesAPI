package br.com.chacara.repository.specification;

import br.com.chacara.entity.Reserva;
import org.springframework.data.jpa.domain.Specification;

public class ReservaSpecification {

    public static Specification<Reserva> gratherThanConvidados(Long convidados) {
        return (reserva, cq, cb) -> cb.greaterThan(reserva.get("convidados"), convidados);
    }

    public static Specification<Reserva> greatherThanValor(Long valor) {
        return (reserva, cq, cb) -> cb.greaterThan(reserva.get("valor"), valor);
    }

    public static Specification<Reserva> lessThanValor(Long valor) {
        return (reserva, cq, cb) -> cb.lessThan(reserva.get("valor"), valor);
    }
}
