package br.gov.sp.fatec.sprintbootapp.servico;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.sprintbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.sprintbootapp.repository.UsuarioRepository;
import br.gov.sp.fatec.sprintbootapp.entity.Autorizacao;
import br.gov.sp.fatec.sprintbootapp.entity.Usuario;

@Service("segurancaService")
public class SegurancaServiceImp implements SegurancaService {

    @Autowired //istancia para mim o repositorio, ja uso direto
    private AutorizacaoRepository autRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    @Transactional
    public Usuario criarUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autRepo.findByNome(autorizacao);
        if (aut != null){
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }
    
}