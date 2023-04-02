package com.cingest.demo.model.relatorio;

public class GeradorRelatorioColaborador extends GeradorRelatorio{

	public GeradorRelatorioColaborador(String autor, String dataDeEmissao) {
		super(autor, dataDeEmissao);
	}

	@Override
	public IRelatorio getRelatorio() {		
		return new Relatorio("Autor: " + autor + "\\n" + "Data de Emissao: " + dataDeEmissao, "Conteudo: Relatorio Colaborador");
	}

}
