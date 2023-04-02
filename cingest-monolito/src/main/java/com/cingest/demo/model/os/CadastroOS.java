package com.cingest.demo.model.os;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.model.db.IRepositorioOS;
import com.cingest.demo.model.observer.EventManager;

@Component
public class CadastroOS {
	
	@Autowired
	private IRepositorioOS repository;
	
	@Autowired
	private EventManager eventManager;

	public Os getOS(int id) {
		return repository.get(id);
	}

	public List<Os> getOS() {
		return repository.getAll();
	}

	public void insert(Os os) {
		repository.insert(os);
	}

	public void update(int id, Os newOs) {
		Os os = getOS(id);
		if(os != null) {
			String oldStatus = os.getStatus();
			if(!newOs.getTitulo().isBlank()) {
				os.setTitulo(newOs.getTitulo());
			}
			if(!newOs.getResponsavel().isBlank()) {
				os.setReponsavel(newOs.getResponsavel());
			}
			if(!newOs.getSupervisor().isBlank()) {
				os.setSupervisor(newOs.getSupervisor());
			}
			if(!newOs.getCliente().isBlank()) {
				os.setCliente(newOs.getCliente());
			}
			if(!newOs.getStatus().isBlank()) {
				os.setStatus(newOs.getStatus());
			}
			if(!newOs.getInicio().isBlank()) {
				os.setInicio(newOs.getInicio());
			}
			if(!newOs.getFim().isBlank()) {
				os.setFim(newOs.getFim());
			}
			repository.update(os);
			if(!oldStatus.equals("Concluida") && newOs.getStatus().equals("Concluida")) {
				eventManager.notify("Os de id " + os.getId() + " foi finalizada!");
			}
		}
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
