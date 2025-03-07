package org.generation.jaita138.esercitazione.Controller;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Genere;
import org.generation.jaita138.esercitazione.db.service.GenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/v1/genere")
public class GenereController {

    @Autowired
    private GenereService genereService;

    @GetMapping
    public ResponseEntity<List<Genere>> getGenere() {
        
        List<Genere> generi = genereService.findAll();
        return ResponseEntity.ok(generi);
    }

}
