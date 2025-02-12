package org.generation.jaita138.esercitazione.CliManager;

import java.util.List;
import java.util.Scanner;

import org.generation.jaita138.esercitazione.db.entity.Libro;
import org.generation.jaita138.esercitazione.db.entity.Autore;
import org.generation.jaita138.esercitazione.db.entity.Genere;
import org.generation.jaita138.esercitazione.db.service.LibroService;
import org.generation.jaita138.esercitazione.db.service.AutoreService;
import org.generation.jaita138.esercitazione.db.service.GenereService;

public class CliManager {
    private Scanner sc;

    private LibroService libroService;
    private AutoreService autoreService;
    private GenereService genereService;

    public CliManager(LibroService libroService, GenereService genereService, AutoreService autoreService) {
        sc = new Scanner(System.in);
        this.libroService = libroService;
        this.autoreService = autoreService;
        this.genereService = genereService;

        printOptions();
    }

    private void printSeparetor() {
        System.out.println("------------------------------------------------");
    }

    private void printOptions() {

        System.out.println("Operazioni di lettura:");
        System.out.println("1. Stampa tutti i libri");
        System.out.println("2. Stampa tutti i libri con autore");
        System.out.println("3. Stampa tutti i libri con autore e genere");
        System.out.println("4. Stampa tutti gli autori");
        System.out.println("5. Stampa di tutti i generi");
        System.out.println("6. Lettura di tutti gli autori con relativi libri");
        System.out.println("7. Lettura di tutti i generi con relativi libri");
        System.out.println("Operazioni di scrittura:");
        System.out.println("8. Aggiungi un nuovo autore");
        System.out.println("9. Aggiungi un nuovo genere");
        System.out.println("10. Aggiungi nuovo libro con autori e generi");
        System.out.println("Operazioni di ricerca:");
        System.out.println("11. lettura di tutti i libri con titolo che inizia per `p`");
        System.out.println("12. lettura di tutti i libri prodotti tra il 2000 e il 2020");
        System.out.println("13. ricerca del libro con `ISBN` uguale a 978-3-16-148410-0 ");
        System.out.println("0. Esci");
        printSeparetor();

        System.out.println("Inserisci il numero dell'operazione desiderata:");

        String strValue = sc.nextLine();
        int value = Integer.parseInt(strValue);
        printSeparetor();
        switch (value) {
            case 1:
                stampaLibri();
                break;
            case 2:
                stampaLibriConAutore();
                break;
            case 3:
                stampaLibriConAutoreEGenere();
                break;
            case 4:
                stampaTuttiGliAutori();
                break;
            case 5:
                stampaTuttiIGeneri();
                break;
            case 6:
                letturaAutoriConLibri();
                break;
            case 7:
                letturaGeneriConLibri();
                break;
            case 8:
                aggiungiNuovoAutore();
                break;
            case 9:
                aggiungiNuovoGenere();
                break;
            case 10:
                aggiungiNuovoLibro();
                break;
            case 11:
                letturaLibriConTitoloP();
                break;
            case 12:
                letturaLibriProdottiTra2000E2020();
                break;
            case 13:
                ricercaLibroConISBN();
                break;
            case 0:
                return;
            default:
                System.out.println("Operazione non valida");
                printSeparetor();
                break;
        }
        printOptions();
    }

    private void stampaLibri() {
        List<Libro> libri = libroService.findAll();
        System.out.println("libri:");
        System.out.println(libri);
        printSeparetor();
    }

    private void stampaLibriConAutore() {
        List<Libro> libri = libroService.findAllAutore();
        System.out.println("libri con autore:");

        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println(libro.getAutore());
            printSeparetor();
        }
        printSeparetor();
    }

    private void stampaLibriConAutoreEGenere() {
        List<Libro> libri = libroService.findAllAutoreGenere();
        System.out.println("libri con autore e genere:");

        for (Libro libro : libri) {
            System.out.println(libro);
            System.out.println(libro.getAutore());
            System.out.println(libro.getGeneri());
            printSeparetor();
        }
        printSeparetor();
    }

    private void stampaTuttiGliAutori() {
        List<Autore> autori = autoreService.findAll();
        System.out.println("autori:");
        System.out.println(autori);
        printSeparetor();
    }

    private void stampaTuttiIGeneri() {
        List<Genere> generi = genereService.findAll();
        System.out.println("generi:");
        System.out.println(generi);
        printSeparetor();
    }

    private void letturaAutoriConLibri() {
        List<Autore> autori = autoreService.findAllAutoreLibri();
        System.out.println("autori con libri:");

        for (Autore autore : autori) {
            System.out.println(autore);
            System.out.println(autore.getLibri());
            printSeparetor();
        }
        printSeparetor();
    }

    private void letturaGeneriConLibri() {
        List<Genere> generi = genereService.findAllGenereLibri();
        System.out.println("generi con libri:");

        for (Genere genere : generi) {
            System.out.println(genere);
            System.out.println(genere.getLibri());
            printSeparetor();
        }
        printSeparetor();
    }

    private void aggiungiNuovoAutore() {
        Autore autore = new Autore();

        System.out.println("Inserisci il nome dell'autore:");
        autore.setNome(sc.nextLine());
        printSeparetor();

        System.out.println("Inserisci il cognome dell'autore:");
        autore.setCognome(sc.nextLine());
        printSeparetor();

        System.out.println("Inserisci la nazionalità dell'autore:");
        autore.setNazionalità(sc.nextLine());

        autoreService.save(autore);
        printSeparetor();
    }

    private void aggiungiNuovoGenere() {
        Genere genere = new Genere();

        System.out.println("Inserisci il nome del genere:");
        genere.setNome(sc.nextLine());

        genereService.save(genere);
        printSeparetor();
    }

    private void aggiungiNuovoLibro() {
        Libro libro = new Libro();

        System.out.println("Inserisci il titolo del libro:");
        libro.setTitolo(sc.nextLine());
        printSeparetor();

        System.out.println("Inserisci l'anno di pubblicazione del libro:");
        libro.setAnnoPubblicazione(Integer.parseInt(sc.nextLine()));
        printSeparetor();

        System.out.println("Inserisci l'ISBN del libro:");
        libro.setIsbn(sc.nextLine());
        printSeparetor();

        for (Autore autore : autoreService.findAll()) {
            System.out.println(autore);
            printSeparetor();
        }
        System.out.println("Inserisci l'id dell'autore del libro:");
        Autore autore = autoreService.findById(Long.parseLong(sc.nextLine()));
        if (autore == null) {
            System.out.println("Autore non trovato");
            return;
        }
        libro.setAutore(autore);

        printSeparetor();

        boolean condition = true;
        do {

            List<Integer> generiId = libro.getGeneri().stream()
                    .map(genere -> genere.getId().intValue())
                    .toList();

            genereService.findAll().stream()
                    .filter(genere -> !generiId.contains(genere.getId().intValue()))
                    .forEach(t -> {
                        System.out.println(t);
                        printSeparetor();
                    });

            System.out.println("Inserisci l'id del genere del libro:");
            Genere genere = genereService.findById(Long.parseLong(sc.nextLine()));
            if (genere == null) {
                System.out.println("Genere non trovato");
                return;
            }
            printSeparetor();
            libro.getGeneri().add(genere);

            System.out.println("Vuoi aggiungere un altro genere? (s/n)");
            String value = sc.nextLine();
            printSeparetor();
            if (value.equals("n")) {
                condition = false;
            }
        } while (condition);
        printSeparetor();
        libroService.save(libro);
    }

    private void letturaLibriConTitoloP() {
        System.out.println("libri con titolo che inizia per `p`:");
        List<Libro> libri = libroService.findByTitleStartingWith("p");
        System.out.println(libri);
        printSeparetor();
    }

    private void letturaLibriProdottiTra2000E2020() {
        System.out.println("libri prodotti tra il 2000 e il 2020:");
        List<Libro> libri = libroService.findByAnnoPubblicazioneBetween(2000, 2020);
        System.out.println(libri);
        printSeparetor();
    }

    private void ricercaLibroConISBN() {
        System.out.println("libro con `ISBN` uguale a 978-3-16-148410-0:");
        List<Libro> libri = libroService.findByisbnIs("978-3-16-148410-0");
        System.out.println(libri);
        printSeparetor();
    }
}
