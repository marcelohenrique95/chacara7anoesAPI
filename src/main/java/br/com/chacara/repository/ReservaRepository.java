package br.com.chacara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
	

}
