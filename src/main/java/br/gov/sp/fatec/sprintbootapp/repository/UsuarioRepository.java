package br.gov.sp.fatec.sprintbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.sprintbootapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}