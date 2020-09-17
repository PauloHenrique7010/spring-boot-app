package br.gov.sp.fatec.sprintbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.sprintbootapp.entity.Autorizacao;
import br.gov.sp.fatec.sprintbootapp.entity.Usuario;
import br.gov.sp.fatec.sprintbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.sprintbootapp.repository.UsuarioRepository;

@SpringBootTest
class SprintBootAppApplicationTests {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutorizacaoRepository autorizacaoRepo;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testaInsercao(){
        Usuario usuario = new Usuario();
        usuario.setNome("Segundo usuário3");
        usuario.setSenha("senha");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("Admin2");
        autorizacaoRepo.save(aut);
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getAutorizacoes().iterator().next().getId());
    }

    @Test
    void testaAutorizacao(){
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("Admin", usuario.getAutorizacoes().iterator().next().getNome());

    }

    @Test
    void testaUsuario(){
        Autorizacao aut = autorizacaoRepo.findById(1L).get();
        assertEquals("Primeiro Usuario", aut.getUsuarios().iterator().next().getNome());
    }



}
