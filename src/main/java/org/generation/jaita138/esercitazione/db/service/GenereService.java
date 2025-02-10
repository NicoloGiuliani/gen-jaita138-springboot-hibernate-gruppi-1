package org.generation.jaita138.esercitazione.db.service;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Genere;
import org.generation.jaita138.esercitazione.db.repo.GenereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenereService {

    @Autowired
    private GenereRepo genereRepo;

    public List<Genere> findAll() {

        return genereRepo.findAll();
    }


    public void save(Genere genere) {

        genereRepo.save(genere);
    }
    
}