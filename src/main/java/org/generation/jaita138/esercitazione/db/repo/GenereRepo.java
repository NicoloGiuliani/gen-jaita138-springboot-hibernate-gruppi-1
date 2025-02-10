package org.generation.jaita138.esercitazione.db.repo;
import org.generation.jaita138.esercitazione.db.entity.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenereRepo extends JpaRepository<Genere, Long> {

}