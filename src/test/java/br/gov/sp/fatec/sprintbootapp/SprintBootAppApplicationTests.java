package br.gov.sp.fatec.sprintbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.sprintbootapp.entity.Autorizacao;
import br.gov.sp.fatec.sprintbootapp.entity.Usuario;
import br.gov.sp.fatec.sprintbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.sprintbootapp.repository.UsuarioRepository;

@SpringBootTest
/*@Transactional
@Rollback*/
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
        /*Usuario usuario = new Usuario();
        usuario.setNome("Mais uma");
        usuario.setSenha("senha");
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());*/

        Usuario usuario = new Usuario();
        usuario.setNome("Ultimo");
        usuario.setSenha("senha");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("Admin3");
        autorizacaoRepo.save(aut);
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);        
        assertNotNull(usuario.getAutorizacoes().iterator().next().getId());
    }

    @Test
    void testaInsercaoAutorizacao(){
        /*Usuario usuario = new Usuario();
        usuario.setNome("Mais uma");
        usuario.setSenha("senha");
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getId());*/

        Usuario usuario = new Usuario();
        usuario.setNome("Usuario2");
        usuario.setSenha("senha");
        usuarioRepo.save(usuario);        

        Autorizacao aut = new Autorizacao();
        aut.setNome("Admin4");
        aut.setUsuarios(new HashSet<Usuario>());
        aut.getUsuarios().add(usuario);
        autorizacaoRepo.save(aut);                
        assertNotNull(aut.getUsuarios().iterator().next().getId());
    }


    /*@Test
    void testaAutorizacao(){
        Usuario usuario = usuarioRepo.findById(1L).get();
        assertEquals("Admin", usuario.getAutorizacoes().iterator().next().getNome());

    }

   /* @Test
    void testaUsuario(){
        Autorizacao aut = autorizacaoRepo.findById(1L).get();
        assertEquals("Primeiro Usuario", aut.getUsuarios().iterator().next().getNome());
    }*/

    /*@Test
    void testaBuscaUsuarioNomeContains(){
        List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("Usuario");
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void testaBuscaUsuarioNomeQuery(){
        Usuario usuario = usuarioRepo.buscaPorNome("Ultimo");
        assertNotNull(usuario);
    }

    @Test
    void testaBuscaUsuarioNomeSenhaQuery(){
        Usuario usuario = usuarioRepo.buscaPorNomESenha("Ultimo","senha");
        assertNotNull(usuario);
    }*/


}
