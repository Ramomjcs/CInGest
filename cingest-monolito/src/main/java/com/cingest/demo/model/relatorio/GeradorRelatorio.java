package com.cingest.demo.model.relatorio;

public abstract class GeradorRelatorio {
	protected String autor;
	protected String dataDeEmissao;
	
	public GeradorRelatorio(String autor, String dataDeEmissao) {
		this.autor = autor;
		this.dataDeEmissao = dataDeEmissao;
	}
	
	public abstract IRelatorio getRelatorio();
	
}
