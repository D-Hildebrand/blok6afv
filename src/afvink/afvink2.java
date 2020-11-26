package afvink;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class afvink2 extends JFrame {


    public static void main(String[] args) {

        JFrame errorframe;

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String fileloc = selectedFile.getAbsolutePath();


            File inputfile = new File(fileloc);

            //Hier zet je alvast gene neer, omdat je weet dat er alleen gene objecten in komen
            ArrayList<gene> maploc = new ArrayList();
            ArrayList line = new ArrayList<>();

            //Checking if the inputfile works or not,
            //if it does work, creates string with the file's content
            try {
                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));

                //Om de eerste lijn over te slaan. Lekker slim.
                String firstline = filereader.nextLine();
                firstline = null;

                int its = 0;
                while (filereader.hasNextLine() && its < 60000) {
                    String temp = filereader.nextLine();
                    line.add(temp);
                    try {

                        maploc.add(new gene((temp.split("\t")[1]),
                                (temp.split("\t")[6]),
                                (temp.split("\t")[7]),
                                (temp.split("\t")[11])));
                                its++;

                    } catch (NumberFormatException e) {
                        System.out.println("Bestand corrupt");
                    }
                }
//                System.out.println(maploc);


                long stopwatchstart = System.nanoTime();
                maploc.add(30000, new gene("99","1","63Y5","STRONK"));
//                System.out.println(maploc.get(10000)); //Puur om te checken of de insert werkt
                long stopwatchend = System.nanoTime();
                System.out.println("Inserten duurde: "+ (stopwatchend-stopwatchstart)+" nanoconden");

                stopwatchstart = System.nanoTime();
                System.out.println(maploc.get(16000));
                stopwatchend = System.nanoTime();
                System.out.println("Ophalen & printen duurde: "+ (stopwatchend-stopwatchstart)+" nanoconden");

                stopwatchstart = System.nanoTime();
                for (gene gen : maploc) {
                    if(gen.getGenID() == "25000"){
                        break;
                    }
                }
                stopwatchend = System.nanoTime();
                System.out.println("Vinden genloc: "+ (stopwatchend-stopwatchstart)+" nanoconden");

                stopwatchstart = System.nanoTime();
                Collections.sort(maploc);
                stopwatchend = System.nanoTime();
                System.out.println("Sorteren: "+ (stopwatchend-stopwatchstart)+" nanoconden");



            } catch (FileNotFoundException exception) {
                errorframe = new JFrame();
                JOptionPane.showMessageDialog(errorframe, "Bestand niet gevonden, probeer opnieuw",
                        "Critical error", JOptionPane.WARNING_MESSAGE);
                return;
            }

        }
    }
}

class gene implements Comparable<gene> {

    private String genID;
    private String chromosome;
    private String mapLocation;
    private String symbol;


    public gene(String genID, String chromosome, String mapLocation, String symbol) {
        this.genID = genID;
        this.chromosome = chromosome;
        this.mapLocation = mapLocation;
        this.symbol = symbol;
    }

    public String toString() {
//        return "ID: "+ genID+ "chromosome: "+chromosome;
        //return String.valueOf(genID);
        return genID+"\t"+"Maplocation: "+mapLocation+"  Symbol: "+symbol+"\n";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int compareTo(gene g) {
        return this.getMapLocation().compareTo(((gene) g).getMapLocation());
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