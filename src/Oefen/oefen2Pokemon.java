package Oefen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class oefen2Pokemon {
    public static void main(String[] args) {
        LinkedList<Pokemon> arrPok = new LinkedList<Pokemon>();
        arrPok.add(new Pokemon("Pikachu", 100, 70, 1));
        arrPok.add(new Pokemon("Ditto", 17, 90, 4));
        arrPok.add(new Pokemon("Baltasur", 190, 1000, 2));
        arrPok.add(new Pokemon("Sandstorm", 10, 7, 100));
        System.out.println(arrPok);
        Collections.sort(arrPok);
        System.out.println(arrPok);

        // een alternatieve, moderne manier van twee objecten vergelijken.
        // Arrayliast van pokemon, comparator.comparing(OpjectYype Pokemon:: methode die een waarde
        //                                              teruggeeft waarop vergeleken wordt.
        Collections.sort(arrPok, Comparator.comparing(Pokemon::getSnelheid));
        System.out.println(arrPok);
    }
}

class Pokemon implements Comparable {
    private String naam;
    private int kracht;
    private int snelheid;
    private int level;
    private int sort_alg = 0;

    public Pokemon(String naam, int kracht, int snelheid, int level) {
        this.naam = naam;
        this.kracht = kracht;
        this.snelheid = snelheid;
        this.level = level;
    }

    public int compareTo(Pokemon p) {
//        if (sort_alg == 0)
        {
//            Pokemon p = (Pokemon) o; // Je cast een generiek object naar pokemon object.
            if (this.naam.length() > p.getNaam().length()) {
                return +1;
            } else if (this.naam.length() == p.getNaam().length()) {
                return 0;
            } else return -1;
        }
    }

//}

    public String toString() {
        return naam + "\nsnelheid: " + snelheid + "\nkracht: " + kracht + "\nlevel: " + level;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getKracht() {
        return kracht;
    }

    public void setKracht(int kracht) {
        this.kracht = kracht;
    }

    public int getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(int snelheid) {
        this.snelheid = snelheid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}