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
        System.out.println("12. lettura di tutti i libri prodotti tra il **2000** e il **2020**");
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
        // Implementazione del metodo
    }
    
    private void stampaLibriConAutoreEGenere() {
        // Implementazione del metodo
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
        // Implementazione del metodo
    }
    
    private void letturaGeneriConLibri() {
        // Implementazione del metodo
    }
    
    private void aggiungiNuovoAutore() {
        // Implementazione del metodo
    }
    
    private void aggiungiNuovoGenere() {
        // Implementazione del metodo
    }
    
    private void aggiungiNuovoLibro() {
        // Implementazione del metodo
    }
    
    private void letturaLibriConTitoloP() {
        // Implementazione del metodo
    }
    
    private void letturaLibriProdottiTra2000E2020() {
        // Implementazione del metodo
    }
    
    private void ricercaLibroConISBN() {
        // Implementazione del metodo
    }
}
