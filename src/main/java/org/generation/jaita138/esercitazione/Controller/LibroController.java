package org.generation.jaita138.esercitazione.Controller;

import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Libro;
import org.generation.jaita138.esercitazione.db.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://localhost:5173/") // serve per far accedere il front-end ai servizi back-end
@RequestMapping("/api/v1/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getLibro() {

        List<Libro> libri = libroService.findAllAutoreGenere();
        return ResponseEntity.ok(libri);
    }

    @PostMapping
    public ResponseEntity<Libro> creaLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        
        return ResponseEntity.ok(null);
    }
    
}