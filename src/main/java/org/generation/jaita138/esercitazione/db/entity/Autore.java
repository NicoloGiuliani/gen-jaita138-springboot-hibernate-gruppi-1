package org.generation.jaita138.esercitazione.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autore {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String nazionalità;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNazionalità() {
        return nazionalità;
    }
    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }
    @Override
    public String toString() {
        return "Autore [\nid=" + id + ", \nnome=" + nome + ", \ncognome=" + cognome + ", \nnazionalità=" + nazionalità + "]";
    }

    
    
}
