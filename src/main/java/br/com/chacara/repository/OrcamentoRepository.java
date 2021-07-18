package br.com.chacara.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Orcamento;

@Repository
public interface OrcamentoRepository extends CrudRepository<Orcamento, Long> {
		

}
