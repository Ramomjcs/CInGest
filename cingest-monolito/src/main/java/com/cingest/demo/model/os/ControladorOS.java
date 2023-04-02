package com.cingest.demo.model.os;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControladorOS {
	
	@Autowired
	private CadastroOS cadastroOS;

	public Os getOS(int id) {
		return cadastroOS.getOS(id);
	}

	public List<Os> getOS() {
		return cadastroOS.getOS();
	}

	public void insert(Os os) {
		cadastroOS.insert(os);
	}

	public void update(int id, Os os) {
		cadastroOS.update(id, os);
	}

	public void delete(int id) {
		cadastroOS.delete(id);
	}
}
