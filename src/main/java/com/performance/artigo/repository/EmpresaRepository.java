package com.performance.artigo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.performance.artigo.models.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

	@Override
    List<Empresa> findAll();
	
	Empresa findByNome(String name);
}
