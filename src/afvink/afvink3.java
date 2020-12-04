package afvink;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class afvink3 extends JFrame {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Choose array method: 'ArrayList' or 'LinkedList'\n");

        String method = myObj.next();  // Read user input

        boolean goodmethod;
        if (method.toLowerCase().equals("arraylist")) {
            goodmethod = true;
        } else if (method.toLowerCase().equals("linkedlist")) {
            goodmethod = true;
        } else {
            goodmethod = false;
        }


        while (!goodmethod) {
            System.out.println("Wrong method, type again");
            System.out.println("Choose array method: 'ArrayList' or 'LinkedList'\n");
            method = myObj.next();

            if (method.toLowerCase().equals("arraylist")) {
                goodmethod = true;
            } else if (method.toLowerCase().equals("linkedlist")) {
                goodmethod = true;
            } else {
                goodmethod = false;
            }
        }

        if (method.toLowerCase().equals("arraylist")) {

            //Hier zet je alvast gene neer, omdat je weet dat er alleen gene objecten in komen
            ArrayList<gene2> maploc = new ArrayList();
            functiearray(maploc);
        } else {
            //Hier zet je alvast gene neer, omdat je weet dat er alleen gene objecten in komen
            LinkedList<gene2> maploc = new LinkedList();
            functielinked(maploc);
        }


    }

    /**
     * Executes function if selected type is "arraylist"
     *
     * @param maploc
     */
    public static void functiearray(ArrayList maploc) {
        JFrame errorframe;

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String fileloc = selectedFile.getAbsolutePath();


            File inputfile = new File(fileloc);

            try {
                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));

                //Om de eerste lijn over te slaan. Lekker slim.
                String firstline = filereader.nextLine();
                firstline = null;

            } catch (NumberFormatException | FileNotFoundException e) {
                System.out.println("Bestand corrupt");
            }


            try {
                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));

                //Om de eerste lijn over te slaan. Lekker slim.
                String firstline = filereader.nextLine();
                firstline = null;


                // Arraylist to split lines in file
                ArrayList line = new ArrayList<>();

                //its (iterations) for number of lines in file
                int its = 0;
                long stopwatchstart = System.nanoTime();
                while (filereader.hasNextLine() && its < 60000) {
                    String temp = filereader.nextLine();
                    line.add(temp);
                    try {
                        //make a gene from the wanted variables
                        maploc.add(new gene2((temp.split("\t")[1]),
                                (temp.split("\t")[6]),
                                (temp.split("\t")[7]),
                                (temp.split("\t")[11])));
                        its++;

                    } catch (NumberFormatException e) {
                        System.out.println("Bestand corrupt");
                    }
                }


                Collections.sort(maploc);
                long stopwatchend = System.nanoTime();
                System.out.println("ArrayList vullen & sorteren duurde: " + (stopwatchend - stopwatchstart) + " nanoconden");

                stopwatchstart = System.nanoTime();
                System.out.println(maploc.get(30000));
                stopwatchend = System.nanoTime();
                System.out.println("Arraylist regel ophalen & printen duurde: " + (stopwatchend - stopwatchstart) + " nanoconden");


            } catch (FileNotFoundException exception) {
                errorframe = new JFrame();
                JOptionPane.showMessageDialog(errorframe, "Bestand niet gevonden, probeer opnieuw",
                        "Critical error", JOptionPane.WARNING_MESSAGE);
                return;
            }
//                            System.out.println(maploc);

        }
    }

    /**
     * Executes function if selected array type is "linkedlist"
     *
     * @param maploc
     */
    public static void functielinked(LinkedList maploc) {
        JFrame errorframe;

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String fileloc = selectedFile.getAbsolutePath();


            File inputfile = new File(fileloc);

            try {
                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));

                //Om de eerste lijn over te slaan. Lekker slim.
                String firstline = filereader.nextLine();
                firstline = null;

            } catch (NumberFormatException | FileNotFoundException e) {
                System.out.println("Bestand corrupt");
            }


            try {
                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));

                //Om de eerste lijn over te slaan. Lekker slim.
                String firstline = filereader.nextLine();
                firstline = null;


                // Arraylist to split lines in file
                ArrayList line = new ArrayList<>();

                int its = 0;
                long stopwatchstart = System.nanoTime();
                while (filereader.hasNextLine() && its < 60000) {
                    String temp = filereader.nextLine();
                    line.add(temp);
                    try {

                        maploc.add(new gene2((temp.split("\t")[1]),
                                (temp.split("\t")[6]),
                                (temp.split("\t")[7]),
                                (temp.split("\t")[11])));
                        its++;

                    } catch (NumberFormatException e) {
                        System.out.println("Bestand corrupt");
                    }
                }


                Collections.sort(maploc);
                long stopwatchend = System.nanoTime();
                System.out.println("LinkedList vullen & sorteren duurde: " + (stopwatchend - stopwatchstart) + " nanoconden");

                stopwatchstart = System.nanoTime();
                System.out.println(maploc.get(30000));
                stopwatchend = System.nanoTime();
                System.out.println("LinkedList ophalen & printen duurde: " + (stopwatchend - stopwatchstart) + " nanoconden");


            } catch (FileNotFoundException exception) {
                errorframe = new JFrame();
                JOptionPane.showMessageDialog(errorframe, "Bestand niet gevonden, probeer opnieuw",
                        "Critical error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //                System.out.println(maploc);
        }
    }
}

class gene2 implements Comparable<gene2> {

    private String genID;
    private String chromosome;
    private String mapLocation;
    private String symbol;


    public gene2(String genID, String chromosome, String mapLocation, String symbol) {
        this.genID = genID;
        this.chromosome = chromosome;
        this.mapLocation = mapLocation;
        this.symbol = symbol;
    }

    public String toString() {
//        return "ID: "+ genID+ "chromosome: "+chromosome;
        //return String.valueOf(genID);
        return "GenID: " + genID + "\tChromosome: " + chromosome + "\tSymbol: " + symbol + "\n";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int compareTo(gene2 g) {
        return this.getChromosome().compareTo(((gene2) g).getChromosome());
    }


    public String getGenID() {
        return genID;
    }

    public void setGenID(String genID) {
        this.genID = genID;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }


}