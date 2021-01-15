package afvink;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class afvink6 {


    //Global HashMap to use, since lazy
    public Map<String, String> fastaHashMap = new HashMap<>();


    public static void main(String[] args) {
        afvink6 func = new afvink6();
        System.out.println("Kies het rosalind1 bestand");
        func.fileReader();
        String overlap = func.compareValues();
        System.out.println(overlap);
    }

    /**
     * Function to fill fastaHashMap with key and value
     *
     * @param value; a string
     */
    public void mapFiller(String key, String value) {
        fastaHashMap.put(key, value);
    }

    /**
     * Opens a filechooser, when user selects file, uses mapFiller to fill hashmap with values and keys based on selected file input.
     * Fills hashmap with key
     */
    public void fileReader() {
        //Opent een bestand uit de file browser
        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = fc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            String filelocation = selectedFile.getAbsolutePath();
            //Scanner voor lezen van het bestand
            try {
                Scanner filereader = new Scanner(new File(String.valueOf(filelocation)));
                //Voer de functie uit zolang het bestand nog een nieuwe regel

                //Variable for in the while loop
                String key = "";

                //As long as the file is not empty
                while (filereader.hasNextLine()) {
                    String line = filereader.nextLine();

                    if (line.contains(">")) {
                        key = line;
                    } else {
                        mapFiller(key, line);
                    }

                }
            } catch (FileNotFoundException exception) {
                System.out.println("Werkt niet, bestand niet goed of gevonden ofzo.");
            }
        }
    }

    public String compareValues() {
        // o3 overlap
        int overlapLen = 3;

        //String to return to main later on
        String overlap = "Found overlap: \n";

        //For loop to loop through the hashmap
        for (Map.Entry<String, String> entry : fastaHashMap.entrySet()) {

            //Retrieving key and value, placing in string
            String key = entry.getKey();
            String value = entry.getValue();

            //for loop in the for loop to compare the values to eachother
            for (Map.Entry<String, String> entry1 : fastaHashMap.entrySet()) {

                //Retrieving key and value, placing in string
                String key1 = entry1.getKey();
                String value1 = entry1.getValue();

                // If they keys are the same (comparing the the same map item), do nothing
                if (key.equals(key1)) {
                } else {

                    //Get the length of the string
                    int valuelen = value.length();

                      // This was for debugging
//                    String valuesub = value.substring(valuelen-overlapLen,valuelen);
//                    System.out.println(valuesub);
//                    String value1sub = value1.substring(0,overlapLen);
//                    System.out.println(value1sub);

                    //Check if the last chars of first string are the same as the opening chars of second string
                    if (value.substring(valuelen-overlapLen,valuelen).equals(value1.substring(0,overlapLen))){

                        //concat the key names if match is found
                        overlap = overlap + key + " → " + key1 + "\n";
                    }
                }
            }

        }
    return overlap;
    }
}

