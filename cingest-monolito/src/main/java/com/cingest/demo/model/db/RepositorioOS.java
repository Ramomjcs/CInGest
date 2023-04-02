package com.cingest.demo.model.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cingest.demo.model.os.Os;

@Component
public class RepositorioOS implements IRepositorioOS{
	
	@Autowired
	private RepositorioOsJPA repositorio;

	@Override
	public Os get(int id) {
		try {
			return repositorio.findById((long) id).get();
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<Os> getAll() {
		return repositorio.findAll();
	}

	@Override
	public void delete(int id) {
		repositorio.deleteById((long) id);
	}

	@Override
	public void update(Os os) {
		repositorio.save(os);
	}

	@Override
	public void insert(Os os) {
		repositorio.save(os);
	}
}
