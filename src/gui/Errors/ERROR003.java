package gui.Errors;

import gui.guiParoxou.guiAddAccom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ERROR003 extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel message;
    JButton returntoAddAcc;
    public ERROR003() {
        frame = new JFrame();
        frame.setSize(350,150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);

        message = new JLabel("Δεν έχουν συμπληρωθεί τα απαραίτητα πεδία");
        message.setBounds(15,10,300,30);
        panel.add(message);

        returntoAddAcc = new JButton("OK");
        returntoAddAcc.setBounds(250,70,75,25);
        returntoAddAcc.addActionListener(this);
        panel.add(returntoAddAcc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == returntoAddAcc){
            frame.dispose();
            guiAddAccom myGUI = new guiAddAccom();
            myGUI.setVisible(true);
        }
    }
}
