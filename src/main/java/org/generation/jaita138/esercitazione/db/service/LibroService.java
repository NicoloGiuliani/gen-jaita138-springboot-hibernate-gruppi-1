package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Libro;
import org.generation.jaita138.esercitazione.db.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        return libroRepo.findByTitleStartingWith(titolo);
    }
    

    public List<Libro> findByAnnoPubblicazioneBetween(int annoPubblicazione) {

        return libroRepo.findByAnnoPubblicazioneBetween(annoPubblicazione);
    }

    public List<Libro> findByisbnIs(String isbn) {

        return libroRepo.findByisbnIs(isbn);
    }
}