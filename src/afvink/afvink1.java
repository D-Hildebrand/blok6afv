package afvink;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;


public class afvink1 {

    public static void main(String[] args) {

//        JFrame errorframe;
//
//        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//
//        int returnValue = fc.showOpenDialog(null);
//
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fc.getSelectedFile();
//            String fileloc = selectedFile.getAbsolutePath();
//
//
//            File inputfile = new File(fileloc);
//            ArrayList numbers = new ArrayList();
//
//            //Checking if the inputfile works or not,
//            //if it does work, creates string with the file's content
//            try {
//                Scanner filereader = new Scanner(new File(String.valueOf(inputfile)));
//                while (filereader.hasNextLine()) {
////                    int test = (int) filereader.nextLine().trim();
//                    numbers.add(filereader.nextLine().trim());
//
//                }
//
//
//            } catch (FileNotFoundException exception) {
//                errorframe = new JFrame();
//                JOptionPane.showMessageDialog(errorframe, "Bestand niet gevonden, probeer opnieuw",
//                        "Critical error", JOptionPane.WARNING_MESSAGE);
//                return;
//            }

            ArrayList temparray = new ArrayList();

            int p = 0;
            while (p < 20000000){
                p++;
                temparray.add(new Random().nextInt(1000000000));
            }

            ArrayList numbers = (ArrayList) temparray.clone();

            long stopwatchstart = System.currentTimeMillis();



            // Grootte / complexiteit van de array
            // Numbers is het bestand wat ingevoerd is
            int n = numbers.size();

            for (int gap = n/2; gap > 0; gap /=2) {
                for (int i = gap; i < n; i++ ){

                    int temp = Integer.parseInt(String.valueOf(numbers.get(i)));
                    int j = i;
                    while (j >= gap && Integer.parseInt(String.valueOf(numbers.get(j-gap))) > temp){
                        numbers.set(j, numbers.get(j - gap));
                        j -= gap;

                    }
                    numbers.set(j, temp);

                }
            }

            long stopwatchend = System.currentTimeMillis();
            System.out.println("Het duurde: "+ (stopwatchend-stopwatchstart));
//            for (Object number : numbers) {
//                System.out.println(number);

            }
        }


