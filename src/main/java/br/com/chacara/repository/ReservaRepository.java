package br.com.chacara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
