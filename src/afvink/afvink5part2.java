package afvink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class afvink5part2 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> one = new HashMap<>(20);
        one.put("A", "Ala, Alanine");
        one.put("R", "Arg, Arginine");
        one.put("N", "Asn, Asparagine");
        one.put("D", "Asp, Asparaginezuur");
        one.put("C", "Cys, Cysteine");
        one.put("E", "Glu, Glutaminezuur");
        one.put("Q", "Gln, Glutamine");
        one.put("G", "Gly, Glycine");
        one.put("H", "His, Histidine");
        one.put("I", "Ile, Isoleucine");
        one.put("L", "Leu, Leucine");
        one.put("K", "Lys, Lysine");
        one.put("M", "Met, Methionine");
        one.put("F", "Phe, Phenylaline");
        one.put("P", "Pro, Proline");
        one.put("S", "Ser, Serine");
        one.put("T", "Thr, Threonine");
        one.put("W", "Trp, Tryptofaan");
        one.put("Y", "Tyr, Tyrosine");
        one.put("V", "Val, Valine");

        HashMap<String, String> three = new HashMap<>(20);
        three.put("Ala", "A, Alanine");
        three.put("Arg", "R, Arginine");
        three.put("Asn", "N, Asparagine");
        three.put("Asp", "D, Asparaginezuur");
        three.put("Cys", "C, Cysteine");
        three.put("Glu", "E, Glutaminezuur");
        three.put("Gln", "Q, Glutamine");
        three.put("Gly", "G, Glycine");
        three.put("His", "H, Histidine");
        three.put("Ile", "I, Isoleucine");
        three.put("Leu", "L, Leucine");
        three.put("Lys", "K, Lysine");
        three.put("Met", "M, Metheonine");
        three.put("Phe", "F, Phenylaline");
        three.put("Pro", "P, Proline");
        three.put("Ser", "S, Serine");
        three.put("Thr", "T, Threonine");
        three.put("Trp", "W, Tryptofaan");
        three.put("Tyr", "Y, Tyrosine");
        three.put("Val", "V, Valine");

        HashMap<String, String> all = new HashMap<>(20);
        all.put("Alanine", "A, Ala");
        all.put("Arginine", "R, Arg");
        all.put("Asparagine", "N, Asn");
        all.put("Asparaginezuur", "D, Asp");
        all.put("Cysteine", "C, Cys");
        all.put("Glutaminezuur", "E, Glu");
        all.put("Glutamine", "Q, Gln");
        all.put("Glycine", "G, Gly");
        all.put("Histidine", "H, His");
        all.put("Isoleucine", "I, Ile");
        all.put("Leucine", "L, Leu");
        all.put("Lysine", "K, Lys");
        all.put("Metheonine", "M, Met");
        all.put("Phenylaline", "F, Phe");
        all.put("Proline", "P, Pro");
        all.put("Serine", "S, Ser");
        all.put("Threonine", "T, Thr");
        all.put("Tryptofaan", "W, Trp");
        all.put("Tyrosine", "Y, Tyr");
        all.put("Valine", "V, Val");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Voer een aminozuur in, eenletterige code, drieletterige code of volledige naam." +
                "Het eerste letter moet een hoofdletter zijn.\nVul in: ");

        String input = reader.readLine();
        if (one.containsKey(input)) {
            System.out.println(input + " -> " + one.get(input));
        } else if (three.containsKey(input)) {
            System.out.println(input + " -> " + three.get(input));
        } else if (all.containsKey(input)) {
            System.out.println(input + " -> " + all.get(input));
        }
    }
}
