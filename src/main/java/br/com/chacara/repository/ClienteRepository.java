package br.com.chacara.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByEmail (String email);
	
	List<Cliente> findByNome (String nome);

	List<Cliente> findByNomeOrEmail (String nome, String email);

	// EXEMPLO DE QUERY JPQL E QUERY NATIVA
	@Query(value = " select c from Cliente c where c.endereco like :endereco")
	//@Query(value = " select * from cliente c where c.endereco like '%:endereco%'", nativeQuery = true)
	List<Cliente> buscaPorEndereco (@Param("endereco") String endereco);

}
