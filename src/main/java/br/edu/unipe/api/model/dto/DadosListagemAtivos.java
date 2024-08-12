package br.edu.unipe.api.model.dto;

import br.edu.unipe.api.model.Ativo;

public record DadosListagemAtivos(String nome, String papel) {
	
	public DadosListagemAtivos(Ativo ativo) {
		this(ativo.getNome(),ativo.getPapel());
	}

}
