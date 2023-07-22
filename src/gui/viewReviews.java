package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import api.fileEditor;
import gui.guiParoxou.MainMenuParoxou;
import gui.guiXrhsth.MainMenuXrhsth;
import static gui.guiParoxou.MainMenuParoxou.acc;
import static gui.GUIlogin.activeUser;

public class viewReviews extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton back;
    JTextArea review;
    public  int i;
    public  String[] contentRev;
    JLabel date;

    public viewReviews() throws FileNotFoundException {

        frame = new JFrame();
        frame.setSize(600, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        back =new JButton("Πίσω");
        back.setBounds(20,20,100,25);
        back.addActionListener(this);
        panel.add(back);

        File directoryPath = new File("Files\\Reviews");
        contentRev = directoryPath.list();

        if (contentRev != null) {
            review = new JTextArea();
            review.setBounds(50, 230, 200, 25);

            Integer y1=50;

            for ( i = 0; i < contentRev.length; i++) {
                if(fileEditor.read("Files\\Reviews\\"+contentRev[i],2).equals(acc)){
                    try {
                        JLabel labelName = new JLabel(contentRev[i].substring(0, contentRev[i].length() - 4) + ":");
                        labelName.setBounds(30, y1, 150, 25);
                        JLabel labelRating = new JLabel("Αστέρια: " + fileEditor.read("Files\\Reviews\\" + contentRev[i], 3));
                        labelRating.setBounds(200, y1, 100, 25);
                        date = new JLabel("Ημερομηνία: " + fileEditor.read("Files\\Reviews\\" + contentRev[i], 4));
                        date.setBounds(330, y1, 200, 25);
                        review = new JTextArea();
                        review.setText(fileEditor.read("Files\\Reviews\\" + contentRev[i], 5));
                        review.setEditable(false);
                        review.setBounds(30, y1 + 30, 500, 150);
                        JScrollPane scroll = new JScrollPane(review);
                        scroll.setBounds(550, 5, 20, 950);
                        panel.add(labelRating);
                        panel.add(labelName);
                        panel.add(review);
                        panel.add(scroll);
                        panel.add(date);
                        y1 = y1 + 250;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        frame.setVisible(true);
        panel.setVisible(true);

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
    }
}
