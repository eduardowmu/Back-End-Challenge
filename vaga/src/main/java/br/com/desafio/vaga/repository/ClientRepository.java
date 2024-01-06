package br.com.desafio.vaga.repository;

import br.com.desafio.vaga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.desafio.vaga.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByDocument(String document);
    Optional<Client> findByUser(User user);
}