package gui.guiXrhsth;

import api.Reviews;
import api.fileEditor;
import gui.Errors.ReviewERROR1;
import gui.Errors.ReviewERROR2;
import gui.Errors.ReviewERROR3;
import gui.guiViewAccom;
import gui.viewReviews;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.acc;

public class addReview implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel userName;
    JLabel accName;
    JTextArea reviewTextArea;
    JLabel reviewText;
    JComboBox<Integer> rating;
    JLabel ratingText;
    JButton add;
    JButton back;
    JLabel date;
    JTextField dateText;

    public addReview(){
        frame = new JFrame();
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        userName = new JLabel("Username χρήστη: "+activeUser);
        userName.setBounds(30,30,300,25);
        panel.add(userName);

        accName = new JLabel("Όνομα καταλύμα: "+acc);
        accName.setBounds(30,85,300,25);
        panel.add(accName);

        ratingText = new JLabel("Επιλέξτε βαθμολογία απο 1 μέχρι και 5 αστέρια:");
        ratingText.setBounds(30,140,350,25);
        panel.add(ratingText);

        rating = new JComboBox<>();
        rating.setBounds(410,140,50,30);
        rating.addItem(1);
        rating.addItem(2);
        rating.addItem(3);
        rating.addItem(4);
        rating.addItem(5);
        panel.add(rating);

        reviewText = new JLabel("Αξιολογήστε το κατάλυμα με ένα μικρό κείμενο:");
        reviewText.setBounds(30,200,400,25);
        panel.add(reviewText);

        reviewTextArea = new JTextArea();
        reviewTextArea.setBounds(20,240,540,300);
        panel.add(reviewTextArea);

        date = new JLabel("Ημερομηνία: ");
        date.setBounds(30,560,100,25);
        panel.add(date);

        dateText = new JTextField();
        dateText.setBounds(101,560,200,25);
        panel.add(dateText);

        back = new JButton("Πίσω");
        back.setBounds(280,610,130,30);
        back.addActionListener(this);
        panel.add(back);

        add = new JButton("Καταχώρηση");
        add.setBounds(440,610,130,30);
        add.addActionListener(this);
        panel.add(add);

        frame.setVisible(true);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            if(reviewTextArea.getText().equals("")) {
                ReviewERROR2 newGui = new ReviewERROR2();
            }else if(dateText.getText().equals("")) {
                ReviewERROR3 newGui = new ReviewERROR3();
            }else{
                Reviews review = new Reviews(reviewTextArea.getText(),rating.getSelectedItem().toString());
                File file = new File("Files\\Reviews\\"+activeUser+"-"+acc+".txt");
                if(file.isFile()){
                    frame.dispose();
                    try {
                        viewReviews newGui = new viewReviews();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    ReviewERROR1 newGUi = new ReviewERROR1();
                }else{
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    fileEditor.writeReviewFile("Files\\Reviews\\"+activeUser+"-"+acc+".txt", activeUser, acc,rating.getSelectedItem().toString(),dateText.getText(), reviewTextArea.getText());
                    frame.dispose();
                    try {
                        viewReviews newGui = new viewReviews();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }else if(e.getSource()==back){
            frame.dispose();
            try {
                guiViewAccom newGui=new guiViewAccom();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
