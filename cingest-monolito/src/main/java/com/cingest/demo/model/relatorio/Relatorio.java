package com.cingest.demo.model.relatorio;

public class Relatorio implements IRelatorio{
	private String header;
	private String body;
	
	public Relatorio(String header, String body) {
		this.header = header;
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return header + "\\n" + body;
	}
}
