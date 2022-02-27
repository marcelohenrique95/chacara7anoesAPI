package br.com.chacara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chacara.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Client findByEmail (String email);
	
	List<Client> findByName (String name);

}
