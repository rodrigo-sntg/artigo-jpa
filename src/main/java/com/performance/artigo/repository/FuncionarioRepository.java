package com.performance.artigo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.performance.artigo.models.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

	@Override
    List<Funcionario> findAll();
	
	Funcionario findByNome(String name);
}
