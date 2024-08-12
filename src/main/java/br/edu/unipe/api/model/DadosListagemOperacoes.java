package br.edu.unipe.api.model;

public record DadosListagemOperacoes(String papel, double vlrUn, double cp, double lair, int qtdAcm ,double pm, double pf, double vt, double corret, double emolum, double liquid, double registr, double isseOutros) {
	
	public DadosListagemOperacoes(Operacao op) {
		this(op.getPapel(),op.getVlrUn(),op.getCp(), op.getLair(), op.getQtdAcm(),op.getPm(),op.getPf(), op.getVt(), op.getCorret(), op.getEmolum(), op.getLiquid(), op.getRegistr(), op.getIsseOutros());
	}
	

}
