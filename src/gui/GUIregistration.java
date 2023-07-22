package gui;
import api.Xrhsths;
import api.fileEditor;
import gui.Errors.ERROR001;
import gui.Errors.ERROR002;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static gui.GUIlogin.activeUser;

public class GUIregistration extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField fistNameText;
    JTextField lastNameText;
    JTextField usernameText;
    JPasswordField passwordText;
    JComboBox roleBox;
    JButton register;
    JButton back;

    public GUIregistration() {
        frame = new JFrame();
        frame.setSize(450, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        //First Name
        JLabel firstName = new JLabel("Όνομα:");
        firstName.setBounds(40, 20, 120, 25);
        panel.add(firstName);

        fistNameText = new JTextField();
        fistNameText.setBounds(150, 20, 220, 25);
        panel.add(fistNameText);

        //Last Name
        JLabel lastName = new JLabel("Επίθετο:");
        lastName.setBounds(40, 80, 120, 25);
        panel.add(lastName);

        lastNameText = new JTextField();
        lastNameText.setBounds(150, 80, 220, 25);
        panel.add(lastNameText);

        //Username
        JLabel userName = new JLabel("Username:");
        userName.setBounds(40, 140, 120, 25);
        panel.add(userName);

        usernameText = new JTextField();
        usernameText.setBounds(150, 140, 220, 25);
        panel.add(usernameText);

        //Password
        JLabel password = new JLabel("Κωδικός:");
        password.setBounds(40, 200, 120, 25);
        panel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(150, 200, 220, 25);
        panel.add(passwordText);

        //Role
        JLabel role = new JLabel("Ρόλος χρήστη:");
        role.setBounds(40, 260, 120, 25);
        panel.add(role);

        roleBox = new JComboBox<>();
        roleBox.setBounds(150, 260, 220, 25);
        roleBox.addItem("");
        roleBox.addItem("Πάροχος");
        roleBox.addItem("Χρήστης");
        panel.add(roleBox);

        register = new JButton("Εγγραφή");
        register.setBounds(300, 320, 120, 30);
        register.addActionListener(this);
        panel.add(register);

        back = new JButton("Πίσω");
        back.setBounds(20, 320, 120, 30);
        back.addActionListener(this);
        panel.add(back);

        frame.setVisible(true);
        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            //Input to String
            String username = usernameText.getText();
            String firstName = fistNameText.getText();
            String lastName = lastNameText.getText();
            String password = passwordText.getText();
            String role = roleBox.getSelectedItem().toString();
            if (role.equals("")) {
                ERROR002 erGUI = new ERROR002();
                erGUI.setVisible(true);
            } else {
                //Create Class & File object
                Xrhsths neosXrhsths = new Xrhsths(firstName + "", lastName + "", username + "", password + "");
                File fileXrhsth = new File("Files\\Xrhstes\\" + username + ".txt");
                //Create File & Verification
                if (!fileXrhsth.isFile()) {
                    try {
                        fileXrhsth.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //Edit file
                    fileEditor.writeFile("Files\\Xrhstes\\" + username + ".txt", neosXrhsths.getStoixeia(), role);
                    //Go to GUIlogin
                    frame.dispose();
                    GUIlogin myGUIlogin2 = new GUIlogin();
                } else {
                    ERROR001 erGUI = new ERROR001();
                }
            }
        }
    }
}




