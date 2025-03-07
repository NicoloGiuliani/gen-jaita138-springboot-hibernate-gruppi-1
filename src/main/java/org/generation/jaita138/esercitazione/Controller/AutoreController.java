package org.generation.jaita138.esercitazione.Controller;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Autore;
import org.generation.jaita138.esercitazione.db.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/v1/autore")
public class AutoreController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public ResponseEntity<List<Autore>> getAutore() {
        
        List<Autore> autori = autoreService.findAll();
        return ResponseEntity.ok(autori);
    }

}
