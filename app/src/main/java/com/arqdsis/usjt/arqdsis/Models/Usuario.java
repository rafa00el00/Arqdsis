package com.arqdsis.usjt.arqdsis.Models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rafae on 28/10/2017.
 */

public class Usuario implements Serializable {

    private int Id;
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String cpf;
    private Date dataNasc;

    public Usuario() {

    }

    public Usuario(String nomeUsuario, String senha, String nome, String cpf, Date dataNasc) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
