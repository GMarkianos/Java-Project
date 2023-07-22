package gui;

import api.fileEditor;
import gui.guiParoxou.MainMenuParoxou;
import gui.guiParoxou.guiepAccom;
import gui.guiXrhsth.MainMenuXrhsth;
import gui.guiXrhsth.addReview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static gui.guiParoxou.MainMenuParoxou.acc;
import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.accompath;


public class guiViewAccom extends JFrame implements ActionListener {
    public JFrame frame;
    JPanel panel;
    JButton back;
    JButton epAccom;
    JButton delAccom;
    JButton addReview;
    JButton viewRev;
    public  String[] allrev;


    public guiViewAccom() throws FileNotFoundException {

        frame = new JFrame();
        frame.setSize(650, 1000);
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

        String name1 = fileEditor.read(path,2);

        JLabel name2 = new JLabel(name1);
        name2.setBounds(150, 20, 120, 25);
        panel.add(name2);

        JLabel type = new JLabel("Τυπος:");
        type.setBounds(40, 70, 120, 25);
        panel.add(type);

        String type1 = fileEditor.read(path,3);

        JLabel type2 = new JLabel(type1);
        type2.setBounds(150, 70, 120, 25);
        panel.add(type2);

        JLabel address = new JLabel("Όδος:");
        address.setBounds(40, 120, 120, 25);
        panel.add(address);

        String address1 = fileEditor.read(path,4);

        JLabel address2 = new JLabel(address1);
        address2.setBounds(150, 120, 120, 25);
        panel.add(address2);

        JLabel town = new JLabel("Πολη:");
        town.setBounds(40, 170, 120, 25);
        panel.add(town);

        String town1 = fileEditor.read(path,5);

        JLabel town2 = new JLabel(town1);
        town2.setBounds(150, 170, 120, 25);
        panel.add(town2);

        JLabel TaCode = new JLabel("Τ.K.:");
        TaCode.setBounds(40, 220, 120, 25);
        panel.add(TaCode);

        String TaCode1 = fileEditor.read(path,6);

        JLabel TaCode2 = new JLabel(TaCode1);
        TaCode2.setBounds(150, 220, 120, 25);
        panel.add(TaCode2);

        JLabel description = new JLabel("Περιγραφη:");
        description.setBounds(40, 270, 250, 25);
        panel.add(description);

        String description1 = fileEditor.read(path,7);

        JLabel description2 = new JLabel("<html>"+description1+"</html>");
        description2.setBounds(150, 275, 200, 150);
        description2.setVerticalAlignment(JLabel.TOP);
        panel.add(description2);

        JLabel facil = new JLabel("Παροχές:");
        facil.setBounds(40, 420, 120, 25);
        panel.add(facil);

        JLabel view = new JLabel("Θέα:");
        view.setBounds(100, 420, 120, 25);
        panel.add(view);

        String view1 = fileEditor.read(path,8);

        JLabel view2 = new JLabel(view1);
        view2.setBounds(300, 420, 120, 25);
        panel.add(view2);

        JLabel bathroom = new JLabel("Μπάνιο:");
        bathroom.setBounds(100, 470, 120, 25);
        panel.add(bathroom);

        String bathroom1 = fileEditor.read(path,9);

        JLabel bathroom2 = new JLabel(bathroom1);
        bathroom2.setBounds(300, 470, 120, 25);
        panel.add(bathroom2);

        JLabel clothes = new JLabel("Πλυσιμο ρουχων:");
        clothes.setBounds(100, 520, 120, 25);
        panel.add(clothes);

        String clothes1 = fileEditor.read(path,10);

        JLabel clothes2 = new JLabel(clothes1);
        clothes2.setBounds(300, 520, 120, 25);
        panel.add(clothes2);

        JLabel fun = new JLabel("Ψυχαγωγια:");
        fun.setBounds(100, 570, 120, 25);
        panel.add(fun);

        String fun1 = fileEditor.read(path,11);

        JLabel fun2 = new JLabel(fun1);
        fun2.setBounds(300, 570, 120, 25);
        panel.add(fun2);

        JLabel heat = new JLabel("Θερμανση και κλιματισμος:");
        heat.setBounds(100, 620, 170, 25);
        panel.add(heat);

        String heat1 = fileEditor.read(path,12);

        JLabel heat2 = new JLabel(heat1);
        heat2.setBounds(300, 620, 120, 25);
        panel.add(heat2);

        JLabel internet = new JLabel("Διαδικτυο:");
        internet.setBounds(100, 670, 120, 25);
        panel.add(internet);

        String internet1 = fileEditor.read(path,13);

        JLabel internet2 = new JLabel(internet1);
        internet2.setBounds(300, 670, 120, 25);
        panel.add(internet2);

        JLabel kitchen = new JLabel("Κουζίνα και τραπεζαρία:");
        kitchen.setBounds(100, 720, 170, 25);
        panel.add(kitchen);

        String kitchen1 = fileEditor.read(path,14);

        JLabel kitchen2 = new JLabel(kitchen1);
        kitchen2.setBounds(300, 720, 120, 25);
        panel.add(kitchen2);

        JLabel exterior = new JLabel("Εξωτερικος χωρος:");
        exterior.setBounds(100, 770, 170, 25);
        panel.add(exterior);

        String exterior1 = fileEditor.read(path,15);

        JLabel exterior2 = new JLabel(exterior1);
        exterior2.setBounds(300, 770, 120, 25);
        panel.add(exterior2);

        JLabel parking = new JLabel("Χωρος σταθμευσης:");
        parking.setBounds(100, 820, 170, 25);
        panel.add(parking);

        String parking1 = fileEditor.read(path,16);

        JLabel parking2 = new JLabel(parking1);
        parking2.setBounds(300, 820, 300, 25);
        panel.add(parking2);

        if (fileEditor.read(accompath, 1).equals(activeUser)){
            epAccom = new JButton("Επεξεργασία καταχώρησης");
            epAccom.setBounds(310, 870, 230, 25);
            panel.add(epAccom);
            epAccom.addActionListener(this);

            delAccom = new JButton("Διαγραφή καταχώρησης");
            delAccom.setBounds(30, 870, 230, 25);
            panel.add(delAccom);
            delAccom.addActionListener(this);
        }else if(fileEditor.read("Files\\Xrhstes\\"+activeUser+".txt",5).equals("Χρήστης")){
            addReview = new JButton("Προσθήκη αξιολόγησης");
            addReview.setBounds(225, 870, 200, 30);
            addReview.addActionListener(this);
            panel.add(addReview);
        }

        back = new JButton("Επιστροφή στο κεντρικό μενού");
        back.setBounds(60, 920, 230, 30);
        panel.add(back);
        back.addActionListener(this);

        viewRev = new JButton("Αξιολογήσεις");
        viewRev.addActionListener(this);
        viewRev.setBounds(340, 920, 230, 30);
        panel.add(viewRev);

        JLabel numberReviews = new JLabel("Αριθμός αξιολογήσεων ");
        numberReviews.setBounds(400, 80, 350, 25);
        panel.add(numberReviews);

        JLabel numberReviews2 = new JLabel("του καταλύματος :");
        numberReviews2.setBounds(400, 110, 350, 25);
        panel.add(numberReviews2);

        File directoryPath = new File("Files\\Reviews");
        allrev = directoryPath.list();

        int totalA=0;
        float totalS=0;

        if (allrev != null) {
                for (int i = 0; i < allrev.length; i++) {
                    if (fileEditor.read(accompath,2).equals(fileEditor.read("Files\\Reviews\\"+allrev[i],2))){
                        totalA=totalA+1;
                        totalS=totalS+Integer.valueOf(fileEditor.read("Files\\Reviews\\"+allrev[i],3));
                    }
                }
        }

        if(totalA!=0){
            totalS = totalS/totalA;
        }

        JLabel total1 = new JLabel(String.valueOf(totalA));
        total1.setBounds(500, 110, 120, 25);
        panel.add(total1);

        JLabel MesosOros = new JLabel("Μέσος όρος αξιολογήσεων");
        MesosOros.setBounds(400, 160, 350, 25);
        panel.add(MesosOros);

        JLabel MesosOros2 = new JLabel("του καταλύματος :");
        MesosOros2.setBounds(400, 190, 350, 25);
        panel.add(MesosOros2);

        JLabel total2 = new JLabel(String.valueOf(totalS));
        total2.setBounds(500, 190, 120, 25);
        panel.add(total2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
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
        if(e.getSource() == epAccom){
            frame.dispose();
            guiepAccom myGui = null;
            try {
                myGui = new guiepAccom();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        }

        if(e.getSource() == delAccom){
            try {
                File directoryPath = new File("Files\\Reviews");
                allrev = directoryPath.list();
                for (int i = 0; i < allrev.length; i++) {
                    if (fileEditor.read(accompath,2).equals(fileEditor.read("Files\\Reviews\\"+allrev[i],2))){
                        Files.delete(Paths.get("Files\\Reviews\\"+allrev[i]));
                    }
                }

                Files.delete(Paths.get(accompath));

            } catch (IOException ex) {
                throw new RuntimeException(ex);
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
        if(e.getSource()==addReview){
            frame.dispose();
            addReview newGui = new addReview();
        }
        if(e.getSource()==viewRev){
            try {
                acc = fileEditor.read(accompath,2);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();
            try {
                viewReviews newGui = new viewReviews();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
