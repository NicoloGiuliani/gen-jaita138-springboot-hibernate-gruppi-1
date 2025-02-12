package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Libro;
import org.generation.jaita138.esercitazione.db.repo.LibroRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LibroService {

    @Autowired
    private LibroRepo libroRepo;

    public List<Libro> findAll() {

        return libroRepo.findAll();
    }

    public void save(Libro libro) {

        libroRepo.save(libro);
    }

    public List<Libro> findByTitleStartingWith(String titolo) {

        return libroRepo.findByTitoloStartingWith(titolo);
    }

    public List<Libro> findByAnnoPubblicazioneBetween(int annoPubblicazioneMinimo, int annoPubblicazioneMassimo) {

        return libroRepo.findByAnnoPubblicazioneBetween(annoPubblicazioneMinimo, annoPubblicazioneMassimo);
    }

    public List<Libro> findByisbnIs(String isbn) {

        return libroRepo.findByisbnIs(isbn);
    }

    @Transactional
    public List<Libro> findAllAutoreGenere() {
        List<Libro> libri = libroRepo.findAll();

        for (Libro libro : libri) {
            Hibernate.initialize(libro.getAutore());
            Hibernate.initialize(libro.getGeneri());
        }
        return libri;
    }

    @Transactional
    public List<Libro> findAllAutore() {
        List<Libro> libri = libroRepo.findAll();

        for (Libro libro : libri) {
            Hibernate.initialize(libro.getAutore());
        }
        return libri;
    }

    @Transactional
    public Libro findById(Long id) {

        Libro libro = libroRepo.findById(id).orElse(null);
        if (libro != null) {
            Hibernate.initialize(libro.getAutore());
            Hibernate.initialize(libro.getGeneri());
        }
        return libro;
    }
}