package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Autore;
import org.generation.jaita138.esercitazione.db.repo.AutoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepo autoreRepo;

    public List<Autore> findAll() {

        return autoreRepo.findAll();
    }

    public void save(Autore autore) {

        autoreRepo.save(autore);
    }
    
}