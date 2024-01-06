package br.com.challenge.baas.repository;

import br.com.challenge.baas.model.Client;
import br.com.challenge.baas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByDocument(String document);
    Optional<Client> findByUser(User user);
}