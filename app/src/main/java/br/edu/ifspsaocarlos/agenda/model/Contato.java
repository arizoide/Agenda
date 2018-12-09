package br.edu.ifspsaocarlos.agenda.model;

import java.io.Serializable;

public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String fone;
    private String foneAdicional;
    private String email;
    private String emailAdicional;
    private String aniversario;
    private boolean favorito;

    public Contato() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getFoneAdicional() {
        return foneAdicional;
    }

    public void setFoneAdicional(String foneAdicional) {
        this.foneAdicional = foneAdicional;
    }

    public String getEmailAdicional() {
        return emailAdicional;
    }

    public void setEmailAdicional(String emailAdicional) {
        this.emailAdicional = emailAdicional;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
}

