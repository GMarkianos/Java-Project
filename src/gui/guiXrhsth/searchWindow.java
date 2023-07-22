package gui.guiXrhsth;

import api.fileEditor;
import gui.Errors.SearchERROR1;
import gui.Errors.SearchERROR2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class searchWindow implements ActionListener{
    public JFrame frame;
    public static ArrayList<String> result;
    private final JTextField nameText;
    private final JTextField typeText;
    private final JTextField locationText;
    private final JButton button;
    JTextField viewText;
    JTextField bathroomText;
    JTextField clothesText;
    JTextField funText;
    JTextField heatText;
    JTextField internetText;
    JTextField parkingText;
    JTextField kitchenText;
    JTextField exteriorText;
    JButton button1;
    public searchWindow() {
        frame = new JFrame();
        frame.setSize(600, 710);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        button = new JButton("Αναζήτηση");
        button.setBounds(350,620,120,35);
        button.addActionListener(this);
        panel.add(button);

        button1 = new JButton("Πίσω");
        button1.setBounds(80,620,120,35);
        button1.addActionListener(this);
        panel.add(button1);

        JLabel nameLabel = new JLabel("Όνομα καταλύματος:");
        nameLabel.setBounds(20,20,150,25);
        panel.add(nameLabel);
        nameText = new JTextField();
        nameText.setBounds(170,20,220,30);
        panel.add(nameText);

        JLabel typeLabel = new JLabel("Τύπος καταλύματος:");
        typeLabel.setBounds(20,70,150,25);
        panel.add(typeLabel);
        typeText = new JTextField();
        typeText.setBounds(170,70,220,30);
        panel.add(typeText);

        JLabel locationLabel = new JLabel("Τοποθεσία:");
        locationLabel.setBounds(20,120,150,25);
        panel.add(locationLabel);
        locationText = new JTextField();
        locationText.setBounds(170,120,220,30);
        panel.add(locationText);

        JLabel facilitiesLabel = new JLabel("Παροχές:");
        facilitiesLabel.setBounds(20,170,150,25);
        panel.add(facilitiesLabel);

        JLabel view = new JLabel("Θέα*:");
        view.setBounds(100, 180, 120, 25);
        panel.add(view);

        viewText = new JTextField();
        viewText.setBounds(270, 180, 220, 25);
        panel.add(viewText);

        JLabel bathroom = new JLabel("Μπάνιο*:");
        bathroom.setBounds(100, 220, 120, 25);
        panel.add(bathroom);

        bathroomText = new JTextField();
        bathroomText.setBounds(270, 220, 220, 25);
        panel.add(bathroomText);

        JLabel clothes = new JLabel("Πλυσιμο ρουχων*:");
        clothes.setBounds(100, 280, 120, 25);
        panel.add(clothes);

        clothesText = new JTextField();
        clothesText.setBounds(270, 280, 220, 25);
        panel.add(clothesText);

        JLabel fun = new JLabel("Ψυχαγωγια*:");
        fun.setBounds(100, 320, 120, 25);
        panel.add(fun);

        funText = new JTextField();
        funText.setBounds(270, 320, 220, 25);
        panel.add(funText);

        JLabel heat = new JLabel("Θερμανση και κλιματισμος*:");
        heat.setBounds(100, 370, 170, 25);
        panel.add(heat);

        heatText = new JTextField();
        heatText.setBounds(270, 370, 220, 25);
        panel.add(heatText);

        JLabel internet = new JLabel("Διαδικτυο*:");
        internet.setBounds(100, 420, 120, 25);
        panel.add(internet);

        internetText = new JTextField();
        internetText.setBounds(270, 420, 220, 25);
        panel.add(internetText);

        JLabel kitchen = new JLabel("Κουζίνα και τραπεζαρία*:");
        kitchen.setBounds(100, 470, 170, 25);
        panel.add(kitchen);

        kitchenText = new JTextField();
        kitchenText.setBounds(270, 470, 220, 25);
        panel.add(kitchenText);

        JLabel exterior = new JLabel("Εξωτερικος χωρος*:");
        exterior.setBounds(100, 520, 170, 25);
        panel.add(exterior);

        exteriorText = new JTextField();
        exteriorText.setBounds(270, 520, 220, 25);
        panel.add(exteriorText);

        JLabel parking = new JLabel("Χωρος σταθμευσης*:");
        parking.setBounds(100, 570, 170, 25);
        panel.add(parking);

        parkingText = new JTextField();
        parkingText.setBounds(270, 570, 220, 25);
        panel.add(parkingText);

        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            result=fileEditor.searchFiles(nameText.getText(),typeText.getText(),locationText.getText(),viewText.getText(),bathroomText.getText(),clothesText.getText(),
                    funText.getText(),heatText.getText(),internetText.getText(),kitchenText.getText(),exteriorText.getText(),parkingText.getText());

            if((nameText.getText().equals(""))&&(typeText.getText().equals(""))&&(locationText.getText().equals(""))&&(viewText.getText().equals(""))&&(bathroomText.getText().equals(""))&&(clothesText.getText().equals(""))&&
               (funText.getText().equals(""))&&(heatText.getText().equals(""))&&(internetText.getText().equals(""))&&(kitchenText.getText().equals(""))&&(exteriorText.getText().equals(""))&&(parkingText.getText().equals("")))
            {
                SearchERROR2 newGui = new SearchERROR2();
            }else{
                if (result.isEmpty()) {
                    new SearchERROR1();
                }else{
                    frame.dispose();
                    try {
                        searchResults newGui = new searchResults();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }else if(e.getSource()==button1){
            frame.dispose();
            MainMenuXrhsth newGui = new MainMenuXrhsth();
        }

    }

}
