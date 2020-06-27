package com.performance.artigo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.performance.artigo.models.Empresa;
import com.performance.artigo.models.Funcionario;
import com.performance.artigo.repository.EmpresaRepository;
import com.performance.artigo.repository.FuncionarioRepository;

@SpringBootApplication
@EntityScan(basePackages = "com.performance.artigo.*")
public class JpaPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPerformanceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(FuncionarioRepository repository, EmpresaRepository empresaRepository) {
		return args -> {
			
			for(int i = 0; i < 10; i++) {
				
				Empresa e = new Empresa("VoceSA" + i);
				empresaRepository.save(e);
				
				Funcionario f1 = new Funcionario("um" + i);
				f1.setEmpresa(e);
				repository.save(f1);
				Funcionario f2 = new Funcionario("dois" + i);
				f2.setEmpresa(e);
				repository.save(f2);
				Funcionario f3 = new Funcionario("tres" + i);
				f3.setEmpresa(e);
				repository.save(f3);
				
				List<Funcionario> funcionarios = new ArrayList<>();
				funcionarios.add(f1);
				funcionarios.add(f2);
				funcionarios.add(f3);
				
				e.setFuncionarios(funcionarios);
				
				empresaRepository.save(e);
			}
		};
	}

}
