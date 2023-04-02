package com.cingest.demo.model.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.controll.IComunicacaoSistemaExterno;

@Component
public class DiscordAlert implements EventListener {
	
	@Autowired
	private IComunicacaoSistemaExterno comunicacao;
	
	@Override
	public void alert(String message, String server) {
		comunicacao.sendMessage(message, server);
	}

}
