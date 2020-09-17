package br.gov.sp.fatec.sprintbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.sprintbootapp.entity.Usuario;
import br.gov.sp.fatec.sprintbootapp.repository.UsuarioRepository;

@SpringBootTest
@Transactional
@Rollback
class SprintBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao(){
        Usuario usuario = new Usuario();
        usuario.setNome("Segundo usuário");
        usuario.setSenha("senha");
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId()); 

    }

}
