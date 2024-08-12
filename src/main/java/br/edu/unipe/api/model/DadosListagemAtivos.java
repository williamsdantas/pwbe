package br.edu.unipe.api.model;

public record DadosListagemAtivos(String nome, String papel) {
	
	public DadosListagemAtivos(Ativo ativo) {
		this(ativo.getNome(),ativo.getPapel());
	}

}
