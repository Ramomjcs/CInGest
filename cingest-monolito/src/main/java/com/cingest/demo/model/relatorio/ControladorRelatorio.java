package com.cingest.demo.model.relatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.controll.IComunicacaoSistemaExterno;
import com.cingest.demo.model.util.ApplicationConstants;

@Component
public class ControladorRelatorio {
	
	@Autowired
	private IComunicacaoSistemaExterno comunicacao;
	
	public void exportarRelatorio(String cargo) {
		GeradorRelatorio gerador;
		switch(cargo) {
			case "cliente":
				gerador = new GeradorRelatorioCliente("user", "agora");
				break;
			case "colaborador":
				gerador = new GeradorRelatorioColaborador("user", "agora");
				break;
			default:
				gerador = new GeradorRelatorioSupervisor("user", "agora");
				break;	
		}
		comunicacao.sendMessage(gerador.getRelatorio().toString(), ApplicationConstants.WEBHOOK_URL);
	}
}
