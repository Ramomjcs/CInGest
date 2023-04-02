package com.cingest.demo.controll;

public interface IComunicacaoSistemaExterno {
	
	public boolean sendMessage(String message, String webhookUrl);
}
