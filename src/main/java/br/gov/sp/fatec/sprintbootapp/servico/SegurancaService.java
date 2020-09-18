package br.gov.sp.fatec.sprintbootapp.servico;

import br.gov.sp.fatec.sprintbootapp.entity.Usuario;

public interface SegurancaService {
    public Usuario criarUsuario(String nome, String senha, String autorizacao);
    
}