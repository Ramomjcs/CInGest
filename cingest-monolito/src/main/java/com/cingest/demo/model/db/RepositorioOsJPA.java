package com.cingest.demo.model.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cingest.demo.model.os.Os;

public interface RepositorioOsJPA extends JpaRepository<Os, Long>{

}
