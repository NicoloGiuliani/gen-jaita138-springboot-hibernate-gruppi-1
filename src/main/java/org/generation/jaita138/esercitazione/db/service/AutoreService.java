package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Autore;
import org.generation.jaita138.esercitazione.db.repo.AutoreRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AutoreService {
    
    @Autowired
    private AutoreRepo autoreRepo;

    public List<Autore> findAll() {

        return autoreRepo.findAll();
    }

    @Transactional
    public List<Autore> findAllAutoreLibri() {
        List<Autore> autori = autoreRepo.findAll();
        
        for (Autore autore : autori) {
            Hibernate.initialize(autore.getLibri());
        }
        return autori;
    }

    @Transactional
    public Autore findById(Long id) {
        
        Autore autore = autoreRepo.findById(id).orElse(null);
        
        if (autore != null) {
            Hibernate.initialize(autore.getLibri());
        }
        return autore;
    }


    public void save(Autore autore) {

        autoreRepo.save(autore);
    }
    
}