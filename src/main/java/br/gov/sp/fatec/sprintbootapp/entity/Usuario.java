package br.gov.sp.fatec.sprintbootapp.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario")
    private Long id;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_autorizacao",
                joinColumns = {@JoinColumn(name = "cod_usuario")},
                inverseJoinColumns = {@JoinColumn(name = "cod_aut")}
                )
    private Set<Autorizacao> autorizacoes;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Set<Autorizacao> getAutorizacoes(){
        return this.autorizacoes;
    }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes){
        this.autorizacoes = autorizacoes;
    }
    
}