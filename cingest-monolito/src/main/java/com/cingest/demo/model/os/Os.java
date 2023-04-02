package com.cingest.demo.model.os;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Os {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String titulo;
	private String responsavel;
	private String supervisor;
	private String cliente;
	private String status;
	private String inicio;
	private String fim;
	
	public Os() {}
	
	public Os(String titulo, String responsavel, String supervisor, String cliente, String status, String inicio,
			String fim) {
		this.titulo = titulo;
		this.responsavel = responsavel;
		this.supervisor = supervisor;
		this.cliente = cliente;
		this.status = status;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setReponsavel(String reponsavel) {
		this.responsavel = reponsavel;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFim() {
		return fim;
	}
	public void setFim(String fim) {
		this.fim = fim;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fim, inicio, responsavel, status, supervisor, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Os other = (Os) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fim, other.fim)
				&& Objects.equals(inicio, other.inicio) && Objects.equals(responsavel, other.responsavel)
				&& Objects.equals(status, other.status) && Objects.equals(supervisor, other.supervisor)
				&& Objects.equals(titulo, other.titulo);
	}
}