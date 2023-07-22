package gui;
import api.XrhsthsLoginVerification;
import gui.guiParoxou.MainMenuParoxou;
import api.fileEditor;
import gui.guiXrhsth.MainMenuXrhsth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import static api.XrhsthsLoginVerification.verified;

public  class GUIlogin extends JFrame implements ActionListener {
    public static String activeUser;
    public JFrame frame;
    JPanel panel;
    JButton login;
    JButton sub;
   static JTextField usernameText;
    JPasswordField passwordText;
    public  GUIlogin(){
        frame = new JFrame();
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel username = new JLabel("Username:");
        username.setBounds(20,10,80,25 );
        panel.add(username);

        usernameText = new JTextField();
        usernameText.setBounds(100,10,170,25);
        panel.add(usernameText);

        JLabel password = new JLabel("Password:");
        password.setBounds(20,45,80,25);
        panel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(100,45,170,25);
        panel.add(passwordText);

        login = new JButton("Login");
        login.setBounds(100,80,100,30);
        panel.add(login);
        login.addActionListener(this);

        sub = new JButton("Κάντε εγγραφή");
        sub.setBounds(90,120,120,30);
        panel.add(sub);
        sub.addActionListener(this);

        frame.setVisible(true);
        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        activeUser=usernameText.getText();
        //Αλλαγή παραθύρου σε φόρμα εγγραφής.
        if(e.getSource() == sub) {
            frame.dispose();
            GUIregistration myGui = new GUIregistration();
            myGui.frame.setVisible(true);
        }
        //Σύνδεση.
        if(e.getSource().equals(login)){
            try {
                XrhsthsLoginVerification.Verify(username,password,"Files\\Xrhstes\\"+username+".txt");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

            if (verified==true) {
                try {
                    if (fileEditor.read("Files\\Xrhstes\\" + username + ".txt", 5).equals("Πάροχος")){
                        frame.dispose();
                        MainMenuParoxou myGUI = new MainMenuParoxou();
                        myGUI.frame.setVisible(true);
                    }else if(fileEditor.read("Files\\Xrhstes\\" + username + ".txt", 5).equals("Χρήστης")){
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
