package Oefen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// het gaat hier over arrays
public class oefen1 {

    public static void main(String[] args) {
        // declaratie & initalisatie met bepaling grootte van de array
        // Kenmerkend van array: De maat staat vast; het is een type (string of int of object, niet varieren)
        int[] int_array = new int[10];

        // For loop, oude stijl
        for (int i = 0; i<int_array.length; i++){
            System.out.println(int_array[i]);
        }

        // For loop, nieuwe stijl
        for(int x:int_array){
            System.out.println(x);
        }

        String[] Array1 = {
                "E.coli", "C.elegans", "D.melanogaster", "M.musculus", "A.thaliana"
        };
        for (String s : Array1){
            System.out.println(s + "\t");
        }
        String[] Array2 = new String[5];
        System.arraycopy(Array1, 0, Array2, 0, Array1.length);
        System.out.println(Arrays.toString(Array1));
        System.out.println(Arrays.toString(Array2));
        Array2[2] = "S.lycopersicum";
        System.out.println("Wijziging array");
        System.out.println(Arrays.toString(Array1));
        System.out.println(Arrays.toString(Array2));

        // voorbeeldje splitsen & for loop
        String[] arr = "hello world en hallo wereld".split(" ");
        for (String s : arr){
            System.out.println(s);
        }

        // Omdat de lengte niet gespecificeerd is, is de snelheid langzamer.
        // Snelheid van plaatsen van data plaatsen is lager vergeleken met een int array.
        ArrayList<String> str_arr = new ArrayList<String>();
        str_arr.add("Kim");
        str_arr.add("Dominic");
        str_arr.add("Luc");
        str_arr.add("Teun");
        str_arr.add("Nick");
        System.out.println(str_arr);


        // Sorteermogelijkheden
        Collections.sort(str_arr);
        System.out.println(str_arr);
        Collections.reverse(str_arr);
        str_arr.add("Jasper");
        System.out.println(str_arr);
        Collections.shuffle(str_arr);
        System.out.println(str_arr);

        //
    }
}
