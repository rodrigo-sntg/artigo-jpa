package com.performance.artigo;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.performance.artigo.models.Empresa;
import com.performance.artigo.repository.FuncionarioRepository;

@SpringBootTest(properties = "spring.main.web-application-type=reactive")
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureMockMvc
class JpaPerformanceApplicationTests {

	@Autowired
    private TestEntityManager em;
	
	@Test
	public void testWithoutFetch() {
		
		List<Empresa> empresas = em.getEntityManager()
				.createQuery("SELECT e FROM Empresa e", Empresa.class).getResultList();
		
		
		for (Empresa e : empresas) {
		    System.out.println(e.getNome() + " tem " + e.getFuncionarios().size() + " funcionarios.");
		}
	}
	
	@Test
	public void testWithFetch() {
		
		List<Empresa> empresas = em.getEntityManager()
				.createQuery("SELECT e FROM Empresa e join fetch e.funcionarios", Empresa.class).getResultList();
		
		
		for (Empresa e : empresas) {
		    System.out.println(e.getNome() + " tem " + e.getFuncionarios().size() + " funcionarios.");
		}
	}
 
}
