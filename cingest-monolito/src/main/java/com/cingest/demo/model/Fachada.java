package com.cingest.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.model.os.ControladorOS;
import com.cingest.demo.model.os.Os;
import com.cingest.demo.model.relatorio.ControladorRelatorio;

@Component
public class Fachada {
	
	@Autowired
	private ControladorOS controladorOS;
	@Autowired
	private ControladorRelatorio controladorRelatorio;
	
	public Os getOS(int id) {
		return controladorOS.getOS(id);
	}

	public List<Os> getOS() {
		return controladorOS.getOS();
	}

	public void insert(Os os) {
		controladorOS.insert(os);
	}

	public void update(int id, Os os) {
		controladorOS.update(id, os);
	}

	public void delete(int id) {
		controladorOS.delete(id);
	}
	
	public void exportarRelatorio(String cargo) {
		controladorRelatorio.exportarRelatorio(cargo);
	}
}
