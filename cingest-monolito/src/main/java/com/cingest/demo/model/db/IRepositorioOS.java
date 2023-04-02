package com.cingest.demo.model.db;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cingest.demo.model.os.Os;

@Component
public interface IRepositorioOS {
	
	public Os get(int id);
	
	public List<Os> getAll();
	
	public void update(Os os);
	
	public void insert(Os os);
	
	public void delete(int id);
}
