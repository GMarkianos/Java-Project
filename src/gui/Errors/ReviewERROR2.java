package gui.Errors;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewERROR2 implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel message;
    JButton button;

    public ReviewERROR2(){
        frame = new JFrame();
        frame.setSize(350,150);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        message = new JLabel("Παρακαλώ συμπληρώστε όλα τα πεδία.");
        message.setBounds(15,10,300,30);
        panel.add(message);

        button = new JButton("OK");
        button.setBounds(250,70,75,25);
        button.addActionListener(this);
        panel.add(button);

        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            frame.dispose();
        }
    }
}
