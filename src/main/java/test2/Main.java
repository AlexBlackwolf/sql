package test2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Studente> list = new ArrayList<>();
        list.add(new Studente(1, "Al", "For", 23));
        list.add(new Studente(2, "Ab", "Fov", 24));
        list.add(new Studente(3, "Ac", "Foz", 25));

        GestioneStudentiDAO gestioneStudenti = new GestioneStudentiDAO();

        //gestioneStudenti.creaTabellaStudenti();

        for (Studente studente : list) {
            gestioneStudenti.inserisciStudente(studente);
        }
        List<Studente> studentiRecuperati = gestioneStudenti.recuperaStudenti();
        for (Studente studente : studentiRecuperati) {
            System.out.println(studente);
        }
    }
}
