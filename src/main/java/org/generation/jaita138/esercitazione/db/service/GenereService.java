package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Genere;
import org.generation.jaita138.esercitazione.db.repo.GenereRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class GenereService {

    @Autowired
    private GenereRepo genereRepo;

    public List<Genere> findAll() {

        return genereRepo.findAll();
    }  

    @Transactional
    public List<Genere> findAllGenereLibri() {
        List<Genere> generi = genereRepo.findAll();
        
        for (Genere genere : generi) {
            Hibernate.initialize(genere.getLibri());
        }
        return generi;
    }

    @Transactional
    public Genere findById(Long id) {

        return genereRepo.findById(id).orElse(null);
    }

    public void save(Genere genere) {

        genereRepo.save(genere);
    }
    
}