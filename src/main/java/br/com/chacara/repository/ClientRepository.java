package br.com.chacara.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	
	List<Client> findByEmail (String email);

}
