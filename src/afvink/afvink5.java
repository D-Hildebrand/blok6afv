package afvink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class afvink5 extends JFrame implements ActionListener {

    private JLabel label;
    private JTextArea textarea1, textarea2, textarea3, textarea4;
    private JButton button1;
    private JComboBox dropdown;

    public static void main(String[] args) {
        afvink5 frame = new afvink5();
        frame.setSize(625, 450);
        frame.createGUI();
        frame.setVisible(true);
    }


    /**
     * Function to create the GUI
     */
    private void createGUI() {
        //Setting up default options
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        window.setBackground(Color.white);

        //Adding descriptive label
        label = new JLabel("Voeg genen in. Welke genen komen in de geselecteerde vakjes voor? Gemaakt door Dominic :P");
        window.add(label);

        //Dirty way of adding new textareas
//      public void createTextfield(JTextField);
        textarea1 = new JTextArea();
        textarea2 = new JTextArea();
        textarea3 = new JTextArea();
        textarea1.setPreferredSize(new Dimension(175, 200));
        textarea2.setPreferredSize(new Dimension(175, 200));
        textarea3.setPreferredSize(new Dimension(175, 200));
        textarea1.setText("Box1");
        textarea2.setText("Box2");
        textarea3.setText("Box3");
        window.add(textarea1);
        window.add(textarea2);
        window.add(textarea3);

        //Adding actionbutton
        button1 = new JButton();
        button1.setPreferredSize(new Dimension(300, 25));
        button1.setText("Klik hier om te analyseren...");
        button1.addActionListener(this);
        window.add(button1);

        //Placing dropdown menu for analysis options
        String[] optionMenu = {"Allen overeenkomst", "1&2 overeenkomst", "1&3 overeenkomst", "2&3 overeenkomst"};
        dropdown = new JComboBox(optionMenu);
        dropdown.setSelectedIndex(0);
        dropdown.setPreferredSize(new Dimension(300, 25));
        window.add(dropdown);

        //Placing answer text area, starting out with a description
        textarea4 = new JTextArea();
        textarea4.setPreferredSize(new Dimension(600, 150));
        textarea4.setText("De vakjes hierboven zijn vak 1, 2 en 3 respectief.\n" +
                "Hier komen de antwoorden te staan.\n" +
                "Kies in het dropdown menu welke vakken u wilt gaan vergelijken.\n" +
                "Voeg gen-namen toe in de bovenstaande vakken, eindig met een enter.\n" +
                "In dit vak zal de overlap komen te staan, mocht deze er zijn.");
        textarea4.setEditable(false);
        window.add(textarea4);


        // overlap bepalen met twee sets is bigO van 1; set.retainAll(set2)
    }


    /**
     * Function to respond a click, looks at options & analyses input.
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Pulling text from textfields
        String area1 = textarea1.getText();
        String area2 = textarea2.getText();
        String area3 = textarea3.getText();

        //Placing entries from textfields 1, 2 & 3 in hashsets
        Set<String> hash1 = new HashSet<String>(Arrays.asList(area1.split("\n")));
        Set<String> hash2 = new HashSet<String>(Arrays.asList(area2.split("\n")));
        Set<String> hash3 = new HashSet<String>(Arrays.asList(area3.split("\n")));

        //Overlap in all 3 text areas
        if (dropdown.getSelectedIndex()== 0){hash1.retainAll(hash2); hash1.retainAll(hash3);
        if (hash1.isEmpty()){
            textarea4.setText("Er is geen overeenkomst gevonden tussen de 3 vakken.");}
        else{
            textarea4.setText("Gevonden overlap in de 3 vakken:\n"+hash1.toString());}}

        //Overlap in textarea 1&2
        else if (dropdown.getSelectedIndex()== 1) {hash1.retainAll(hash2);
        if (hash1.isEmpty()){
            textarea4.setText("Er is geen overeenkomst gevonden tussen vak 1&2");}
        else {
            textarea4.setText("Gevonden overlap in vak 1&2:\n"+hash1.toString());}}

        //Overlap in textarea1&3
        else if (dropdown.getSelectedIndex()== 2) {hash1.retainAll(hash3);
        if (hash1.isEmpty()){
            textarea4.setText("Er is geen overeenkomst gevonden tussen vak 1&3");}
        else {
            textarea4.setText("Gevonden overlap in vak 1&3:\n"+hash1.toString());}}

        //Overlap in textarea2&3
        else {hash2.retainAll(hash3);
        if (hash2.isEmpty()){
            textarea4.setText("Er is geen overlap gevonden in van 2&3");}
        else {
            textarea4.setText("Gevonden overlap in vak 2&3:\n"+hash2.toString());}}
    }
}
