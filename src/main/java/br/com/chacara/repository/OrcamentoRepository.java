package br.com.chacara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
		

}
