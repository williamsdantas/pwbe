package br.edu.unipe.api.repository;

import br.edu.unipe.api.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AtivoRepository
        extends JpaRepository<Ativo,Integer> {
    Ativo findByNome(String nome);
    Ativo findByPapel(String papel);
}
