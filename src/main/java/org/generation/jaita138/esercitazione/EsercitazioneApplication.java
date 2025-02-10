package org.generation.jaita138.esercitazione;

import org.generation.jaita138.esercitazione.CliManager.CliManager;
import org.generation.jaita138.esercitazione.db.service.AutoreService;
import org.generation.jaita138.esercitazione.db.service.GenereService;
import org.generation.jaita138.esercitazione.db.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsercitazioneApplication implements CommandLineRunner {
	
	@Autowired
	private LibroService libroService;

	@Autowired
	private GenereService genereService;

	@Autowired
	private AutoreService autoreService;

	public static void main(String[] args) {
		SpringApplication.run(EsercitazioneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new CliManager(libroService, genereService, autoreService);
	}
}