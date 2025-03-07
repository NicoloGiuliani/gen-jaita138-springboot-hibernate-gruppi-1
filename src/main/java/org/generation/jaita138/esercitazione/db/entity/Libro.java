package org.generation.jaita138.esercitazione.db.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title is required")
    @Column(length = 64)
    private String titolo;

    private int annoPubblicazione;

    @Column(length = 13)
    private String isbn;

    @ManyToOne
    private Autore autore;

    @JsonBackReference
    @ManyToMany
    private List<Genere> generi = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public List<Genere> getGeneri() {
        return generi;
    }

    public void setGeneri(List<Genere> generi) {
        this.generi = generi;
    }

    public void addGenere(Genere genere) {

        if (generi == null)
            generi = new ArrayList<>();

        if (notContainsGenere(genere))
            generi.add(genere);
    }

    public boolean containsGenere(Genere Genere) {

        if (generi == null)
            generi = new ArrayList<>();

        for (Genere g : generi)
            if (g.getId().equals(Genere.getId()))
                return true;

        return false;
    }

    public boolean notContainsGenere(Genere genere) {

        return !containsGenere(genere);
    }

    @Override
    public int hashCode() {

        return getId().intValue();
    }

    @Override
    public boolean equals(Object obj) {

        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "\nLibro: "
                + "\n[id= " + id
                + "\ntitolo= " + titolo
                + "\nannoPubblicazione= " + annoPubblicazione
                + "\nisbn= " + isbn + "]"
                + "\n";

    }
}