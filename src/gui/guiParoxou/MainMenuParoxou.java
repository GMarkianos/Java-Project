package gui.guiParoxou;

import api.fileEditor;
import gui.GUIlogin;
import gui.guiViewAccom;

import static gui.GUIlogin.activeUser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainMenuParoxou extends JFrame implements ActionListener {

    public JFrame frame ;

    public static String acc;
    public static String accompath;
    public  String[] content;

    public  int i;

    JPanel panel;
    JButton addAccom;
    JButton dash;


    JButton viewAccom;
    JComboBox accBox;
    JButton apoAccom;


    public MainMenuParoxou() throws FileNotFoundException {
        frame = new JFrame();
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel menu = new JLabel("ΚΕΝΤΡΙΚΟ ΜΕΝΟΥ");
        menu.setBounds(250, 20, 200, 25);
        panel.add(menu);


        addAccom = new JButton("Προσθήκη καταχώρησης");
        addAccom.setBounds(200, 70, 200, 25);
        panel.add(addAccom);
        addAccom.addActionListener(this);


        dash = new JButton("Dashboard");
        dash.setBounds(200, 130, 200, 25);
        panel.add(dash);
        dash.addActionListener(this);

        JLabel nameK = new JLabel("Όλα τα καταλύματα :");
        nameK.setBounds(250, 180, 200, 25);
        panel.add(nameK);

        File directoryPath = new File("Files\\Accommodations");
        content = directoryPath.list();


        if (content != null) {
                accBox = new JComboBox<>();
                accBox.setBounds(50, 230, 200, 25);
                for (i = 0; i < content.length; i++) {
                        accBox.addItem(content[i].substring(0, content[i].length() - 4));
                }
                panel.add(accBox);
            }

            viewAccom = new JButton("Προβολή καταχώρησης");
            viewAccom.setBounds(300, 230, 200, 25);
            panel.add(viewAccom);
            viewAccom.addActionListener(this);

            apoAccom = new JButton("Αποσύνδεση");
            apoAccom.setBounds(200, 330, 200, 25);
            panel.add(apoAccom);
            apoAccom.addActionListener(this);


        }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addAccom) {
            frame.dispose();
            guiAddAccom myGui = new guiAddAccom();
            myGui.frame.setVisible(true);
        }

        if (e.getSource() == viewAccom){
            acc = accBox.getSelectedItem().toString();
            accompath = "Files\\Accommodations\\"+acc+".txt";
            frame.dispose();
            guiViewAccom myGui = null;
            try {
                myGui = new guiViewAccom();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        }

        if(e.getSource()==dash){
            frame.dispose();
            DashboardParoxou myGui = null;
            try {
                myGui = new DashboardParoxou();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        }

        if(e.getSource() == apoAccom){
            activeUser = null;
            frame.dispose();
            GUIlogin myGui = new GUIlogin();
            myGui.frame.setVisible(true);
        }
    }
}
