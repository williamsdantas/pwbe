package br.edu.unipe.api.repository;

import br.edu.unipe.api.model.Ativo;
import br.edu.unipe.api.model.Operacao;
import br.edu.unipe.api.model.dto.OperacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperacaoRepository
		extends JpaRepository<Operacao,Integer> {

	List<Operacao> findByPapel(String papel);

}
