package gui.guiParoxou;

import api.Accommodations;
import api.fileEditor;
import gui.Errors.ERROR003;
import gui.guiViewAccom;
import gui.guiXrhsth.MainMenuXrhsth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static api.fileEditor.clearFile;
import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.accompath;

public class guiepAccom extends JFrame implements ActionListener {
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
    JButton add1;

    public guiepAccom() throws FileNotFoundException {
        frame = new JFrame();
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        String path = accompath;

        JLabel name = new JLabel("Όνομα:");
        name.setBounds(40, 20, 120, 25);
        panel.add(name);

        String name1 = fileEditor.read(path, 2);

        nameText = new JTextField(name1);
        nameText.setBounds(150, 20, 220, 25);
        panel.add(nameText);

        JLabel type = new JLabel("Τυπος:");
        type.setBounds(40, 70, 120, 25);
        panel.add(type);

        String type1 = fileEditor.read(path, 3);

        typeText = new JTextField(type1);
        typeText.setBounds(150, 70, 220, 25);
        panel.add(typeText);

        JLabel address = new JLabel("Όδος:");
        address.setBounds(40, 120, 120, 25);
        panel.add(address);

        String address1 = fileEditor.read(path, 4);

        addressText = new JTextField(address1);
        addressText.setBounds(150, 120, 220, 25);
        panel.add(addressText);

        JLabel town = new JLabel("Πολη:");
        town.setBounds(40, 170, 120, 25);
        panel.add(town);

        String town1 = fileEditor.read(path, 5);

        townText = new JTextField(town1);
        townText.setBounds(150, 170, 220, 25);
        panel.add(townText);

        JLabel TaCode = new JLabel("Τ.K.:");
        TaCode.setBounds(40, 220, 120, 25);
        panel.add(TaCode);

        String TaCode1 = fileEditor.read(path, 6);

        TaCodeText = new JTextField(TaCode1);
        TaCodeText.setBounds(150, 220, 220, 25);
        panel.add(TaCodeText);

        JLabel description = new JLabel("Περιγραφη");
        description.setBounds(40, 270, 120, 25);
        panel.add(description);

        String description1 = fileEditor.read(path, 7);

        descriptionText = new JTextField(description1);
        descriptionText.setBounds(150, 270, 220, 25);
        panel.add(descriptionText);

        JLabel facil = new JLabel("Παροχές:");
        facil.setBounds(40, 320, 120, 25);
        panel.add(facil);

        JLabel view = new JLabel("Θέα*:");
        view.setBounds(100, 320, 120, 25);
        panel.add(view);

        String view1 = fileEditor.read(path, 8);

        viewText = new JTextField(view1);
        viewText.setBounds(270, 320, 220, 25);
        panel.add(viewText);

        JLabel bathroom = new JLabel("Μπάνιο*:");
        bathroom.setBounds(100, 370, 120, 25);
        panel.add(bathroom);

        String bathroom1 = fileEditor.read(path, 9);

        bathroomText = new JTextField(bathroom1);
        bathroomText.setBounds(270, 370, 220, 25);
        panel.add(bathroomText);

        JLabel clothes = new JLabel("Πλυσιμο ρουχων*:");
        clothes.setBounds(100, 420, 120, 25);
        panel.add(clothes);

        String clothes1 = fileEditor.read(path, 10);

        clothesText = new JTextField(clothes1);
        clothesText.setBounds(270, 420, 220, 25);
        panel.add(clothesText);

        JLabel fun = new JLabel("Ψυχαγωγια*:");
        fun.setBounds(100, 470, 120, 25);
        panel.add(fun);

        String fun1 = fileEditor.read(path, 11);

        funText = new JTextField(fun1);
        funText.setBounds(270, 470, 220, 25);
        panel.add(funText);

        JLabel heat = new JLabel("Θερμανση και κλιματισμος*:");
        heat.setBounds(100, 520, 170, 25);
        panel.add(heat);

        String heat1 = fileEditor.read(path, 12);

        heatText = new JTextField(heat1);
        heatText.setBounds(270, 520, 220, 25);
        panel.add(heatText);

        JLabel internet = new JLabel("Διαδικτυο*:");
        internet.setBounds(100, 570, 120, 25);
        panel.add(internet);

        String internet1 = fileEditor.read(path, 13);

        internetText = new JTextField(internet1);
        internetText.setBounds(270, 570, 220, 25);
        panel.add(internetText);

        JLabel kitchen = new JLabel("Κουζίνα και τραπεζαρία*:");
        kitchen.setBounds(100, 620, 170, 25);
        panel.add(kitchen);

        String kitchen1 = fileEditor.read(path, 14);

        kitchenText = new JTextField(kitchen1);
        kitchenText.setBounds(270, 620, 220, 25);
        panel.add(kitchenText);

        JLabel exterior = new JLabel("Εξωτερικος χωρος*:");
        exterior.setBounds(100, 670, 170, 25);
        panel.add(exterior);

        String exterior1 = fileEditor.read(path, 15);

        exteriorText = new JTextField(exterior1);
        exteriorText.setBounds(270, 670, 220, 25);
        panel.add(exteriorText);

        JLabel parking = new JLabel("Χωρος σταθμευσης*:");
        parking.setBounds(100, 720, 170, 25);
        panel.add(parking);

        String parking1 = fileEditor.read(path, 16);

        parkingText = new JTextField(parking1);
        parkingText.setBounds(270, 720, 220, 25);
        panel.add(parkingText);

        add1 = new JButton("Τέλος επεξεργασίας");
        add1.setBounds(160, 770, 250, 25);
        add1.addActionListener(this);
        panel.add(add1);

        JLabel essentials = new JLabel("Οι κατηγορίες με αστερίσκο δεν είναι απαραίτητο να συμπληρωθούν .");
        essentials.setBounds(50, 850, 400, 25);
        panel.add(essentials);

        back = new JButton("Επιστροφή στο κεντρικό μενού");
        back.setBounds(160, 900, 250, 25);
        panel.add(back);
        back.addActionListener(this);

        frame.setVisible(true);
        panel.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            MainMenuParoxou myGui = null;
            try {
                myGui = new MainMenuParoxou();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        }
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
            if (name.equals("") || type.equals("") || address.equals("") || town.equals("") || TaCode.equals("") || description.equals("")) {
                frame.dispose();
                ERROR003 erGUI = new ERROR003();
                erGUI.setVisible(true);
            } else {
                try {
                    if (fileEditor.read(accompath, 2) != name || fileEditor.read(accompath, 3) != type || fileEditor.read(accompath, 4) != address || fileEditor.read(accompath, 5) != town || fileEditor.read(accompath, 6) != TaCode || fileEditor.read(accompath, 7) != description || fileEditor.read(accompath, 8) != view || fileEditor.read(accompath, 9) != bathroom || fileEditor.read(accompath, 10) != clothes || fileEditor.read(accompath, 11) != fun || fileEditor.read(accompath, 12) != heat || fileEditor.read(accompath, 13) != internet || fileEditor.read(accompath, 14) != kitchen || fileEditor.read(accompath, 15) != exterior || fileEditor.read(accompath, 16) != parking) {
                        if (fileEditor.read(accompath, 2).equals(name)) {
                            clearFile(accompath);
                            Accommodations accommodation = new Accommodations(name + "", type + "", address + "", town + "", TaCode + "", description + "");
                            accommodation.addFacility(view + "", bathroom + "", clothes + "", fun + "", heat + "", internet + "", kitchen + "", exterior + "", parking + "");
                            fileEditor.writeFileAccommodation("Files\\Accommodations\\" + name + ".txt", accommodation.getStoixeiaAcc(), accommodation.getStoixeiaFac(), activeUser);


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
                                fileEditor.writeFileAccommodation("Files\\Accommodations\\" + name + ".txt", accommodation.getStoixeiaAcc(), accommodation.getStoixeiaFac(), activeUser);
                                try {
                                    Files.delete(Paths.get(accompath));
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                accompath = "Files\\Accommodations\\" + name + ".txt";
                            }
                        }
                            frame.dispose();
                            guiViewAccom myGui = null;
                            try {
                                myGui = new guiViewAccom();
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                            myGui.frame.setVisible(true);

                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}