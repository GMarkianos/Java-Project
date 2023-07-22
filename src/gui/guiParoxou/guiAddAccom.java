package gui.guiParoxou;
import api.Accommodations;
import api.fileEditor;
import gui.Errors.ERROR003;
import gui.guiXrhsth.MainMenuXrhsth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static gui.GUIlogin.activeUser;

public class guiAddAccom extends JFrame implements ActionListener {
    JButton add1;
    public JFrame frame;
    JPanel panel;
    JTextField nameText;
    JTextField typeText;
    JTextField addressText;
    JTextField townText;
    JTextField TaCodeText;
    JTextField descriptionText;
    JTextField viewText;
    JTextField bathroomText;
    JTextField clothesText;
    JTextField funText;
    JTextField heatText;
    JTextField internetText;
    JTextField parkingText;
    JTextField kitchenText;
    JTextField exteriorText;
    JButton back;


    public guiAddAccom() {
        frame = new JFrame();
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel name = new JLabel("Όνομα:");
        name.setBounds(40, 20, 120, 25);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(150, 20, 220, 25);
        panel.add(nameText);

        JLabel type = new JLabel("Τυπος:");
        type.setBounds(40, 70, 120, 25);
        panel.add(type);

        typeText = new JTextField();
        typeText.setBounds(150, 70, 220, 25);
        panel.add(typeText);

        JLabel address = new JLabel("Όδος:");
        address.setBounds(40, 120, 120, 25);
        panel.add(address);

        addressText = new JTextField();
        addressText.setBounds(150, 120, 220, 25);
        panel.add(addressText);

        JLabel town = new JLabel("Πολη:");
        town.setBounds(40, 170, 120, 25);
        panel.add(town);

        townText = new JTextField();
        townText.setBounds(150, 170, 220, 25);
        panel.add(townText);

        JLabel TaCode = new JLabel("Τ.K.:");
        TaCode.setBounds(40, 220, 120, 25);
        panel.add(TaCode);

        TaCodeText = new JTextField();
        TaCodeText.setBounds(150, 220, 220, 25);
        panel.add(TaCodeText);

        JLabel description = new JLabel("Περιγραφη");
        description.setBounds(40, 270, 120, 25);
        panel.add(description);

        descriptionText = new JTextField();
        descriptionText.setBounds(150, 270, 220, 25);
        panel.add(descriptionText);

        JLabel facil = new JLabel("Παροχές:");
        facil.setBounds(40, 320, 120, 25);
        panel.add(facil);

        JLabel view = new JLabel("Θέα*:");
        view.setBounds(100, 320, 120, 25);
        panel.add(view);

        viewText = new JTextField();
        viewText.setBounds(270, 320, 220, 25);
        panel.add(viewText);

        JLabel bathroom = new JLabel("Μπάνιο*:");
        bathroom.setBounds(100, 370, 120, 25);
        panel.add(bathroom);

        bathroomText = new JTextField();
        bathroomText.setBounds(270, 370, 220, 25);
        panel.add(bathroomText);

        JLabel clothes = new JLabel("Πλυσιμο ρουχων*:");
        clothes.setBounds(100, 420, 120, 25);
        panel.add(clothes);

        clothesText = new JTextField();
        clothesText.setBounds(270, 420, 220, 25);
        panel.add(clothesText);

        JLabel fun = new JLabel("Ψυχαγωγια*:");
        fun.setBounds(100, 470, 120, 25);
        panel.add(fun);

        funText = new JTextField();
        funText.setBounds(270, 470, 220, 25);
        panel.add(funText);

        JLabel heat = new JLabel("Θερμανση και κλιματισμος*:");
        heat.setBounds(100, 520, 170, 25);
        panel.add(heat);

        heatText = new JTextField();
        heatText.setBounds(270, 520, 220, 25);
        panel.add(heatText);

        JLabel internet = new JLabel("Διαδικτυο*:");
        internet.setBounds(100, 570, 120, 25);
        panel.add(internet);

        internetText = new JTextField();
        internetText.setBounds(270, 570, 220, 25);
        panel.add(internetText);

        JLabel kitchen = new JLabel("Κουζίνα και τραπεζαρία*:");
        kitchen.setBounds(100, 620, 170, 25);
        panel.add(kitchen);

        kitchenText = new JTextField();
        kitchenText.setBounds(270, 620, 220, 25);
        panel.add(kitchenText);

        JLabel exterior = new JLabel("Εξωτερικος χωρος*:");
        exterior.setBounds(100, 670, 170, 25);
        panel.add(exterior);

        exteriorText = new JTextField();
        exteriorText.setBounds(270, 670, 220, 25);
        panel.add(exteriorText);

        JLabel parking = new JLabel("Χωρος σταθμευσης*:");
        parking.setBounds(100, 720, 170, 25);
        panel.add(parking);

        parkingText = new JTextField();
        parkingText.setBounds(270, 720, 220, 25);
        panel.add(parkingText);

        add1 = new JButton("Καταχωρηση");
        add1.setBounds(230, 770, 120, 25);
        add1.addActionListener(this);
        panel.add(add1);

        JLabel essentials = new JLabel("Οι κατηγορίες με αστερίσκο δεν είναι απαραίτητο να συμπληρωθούν .");
        essentials.setBounds(100, 820, 400, 25);
        panel.add(essentials);

        back = new JButton("Επιστροφή στο κεντρικό μενού");
        back.setBounds(160, 870, 250, 25);
        panel.add(back);
        back.addActionListener(this);

        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add1) {
            String name = nameText.getText();
            String type = typeText.getText();
            String address = addressText.getText();
            String town = townText.getText();
            String TaCode = TaCodeText.getText();
            String description = descriptionText.getText();
            String view = viewText.getText();
            String bathroom = bathroomText.getText();
            String clothes = clothesText.getText();
            String fun = funText.getText();
            String heat = heatText.getText();
            String internet = internetText.getText();
            String kitchen = kitchenText.getText();
            String exterior = exteriorText.getText();
            String parking = parkingText.getText();
            if (name.equals("")|| type.equals("") || address.equals("")|| town.equals("") || TaCode.equals("") || description.equals("")) {
                frame.dispose();
                ERROR003 erGUI = new ERROR003();
                erGUI.setVisible(true);
            } else {
                Accommodations accommodation = new Accommodations(name + "", type + "", address + "", town + "", TaCode + "", description + "");
                accommodation.addFacility(view + "", bathroom + "", clothes + "", fun + "", heat + "", internet + "", kitchen + "", exterior + "", parking + "");
                File fileAccommodation = new File("Files\\Accommodations\\" + name + ".txt");
                if (!fileAccommodation.isFile()) {
                    try {
                        fileAccommodation.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    fileEditor.writeFileAccommodation("Files\\Accommodations\\" + name + ".txt", accommodation.getStoixeiaAcc() , accommodation.getStoixeiaFac(), activeUser);
                }

                }
                frame.dispose();
            MainMenuParoxou myGui = null;
            try {
                myGui = new MainMenuParoxou();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
            }
        if (e.getSource()==back){
            try {
                if (fileEditor.read("Files\\Xrhstes\\" + activeUser + ".txt", 5).equals("Πάροχος")){
                    frame.dispose();
                    MainMenuParoxou myGUI = new MainMenuParoxou();
                    myGUI.frame.setVisible(true);
                }else if(fileEditor.read("Files\\Xrhstes\\" + activeUser + ".txt", 5).equals("Χρήστης")){
                    frame.dispose();
                    MainMenuXrhsth myGUI = new MainMenuXrhsth();
                    myGUI.frame.setVisible(true);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        }
    }

