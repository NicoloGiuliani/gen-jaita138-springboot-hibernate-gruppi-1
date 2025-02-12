package org.generation.jaita138.esercitazione.db.repo;
import java.util.List;

import org.generation.jaita138.esercitazione.db.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {
    
    List<Libro> findByTitoloStartingWith(String titolo);
    List<Libro> findByAnnoPubblicazioneBetween(int annoPubblicazioneMinimo, int annoPubblicazioneMassimo);
    List<Libro> findByisbnIs(String isbn);

}