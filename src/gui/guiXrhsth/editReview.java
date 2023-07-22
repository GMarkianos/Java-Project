package gui.guiXrhsth;

import api.Reviews;
import api.fileEditor;
import gui.Errors.ReviewERROR1;
import gui.Errors.ReviewERROR2;
import gui.guiViewAccom;
import gui.viewReviews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.acc;
import static gui.guiXrhsth.infoWindow.reviewPath;

public class editReview implements ActionListener {
        JFrame frame;
        JPanel panel;
        JLabel userName;
        JLabel accName;
        JTextArea reviewTextArea;
        JLabel reviewText;
        JComboBox<String> rating;
        JLabel ratingText;
        JLabel date;
        JTextField dateText;
        JButton edit;
        JButton back;

        public editReview() throws FileNotFoundException {
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
            rating.addItem("1");
            rating.addItem("2");
            rating.addItem("3");
            rating.addItem("4");
            rating.addItem("5");
            rating.setSelectedItem(fileEditor.read(reviewPath,3));
            panel.add(rating);

            String text = fileEditor.read(reviewPath,5);

            reviewText = new JLabel("Αξιολογήστε το κατάλυμα με ένα μικρό κείμενο:");
            reviewText.setBounds(30,200,400,25);
            panel.add(reviewText);

            reviewTextArea = new JTextArea();
            reviewTextArea.setText(text);
            reviewTextArea.setBounds(20,250,540,300);
            reviewTextArea.setEditable(true);
            panel.add(reviewTextArea);

            back = new JButton("Πίσω");
            back.setBounds(280,590,130,30);
            back.addActionListener(this);
            panel.add(back);

            edit = new JButton("Επεξεργασία");
            edit.setBounds(440,590,130,30);
            edit.addActionListener(this);
            panel.add(edit);

            date = new JLabel("Ημερομηνία: ");
            date.setBounds(30,560,100,25);
            panel.add(date);

            dateText = new JTextField();
            dateText.setBounds(131,560,200,25);
            panel.add(dateText);

            frame.setVisible(true);
            panel.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==edit){
                if(reviewTextArea.getText().equals("")){
                    ReviewERROR2 newGui = new ReviewERROR2();
                }else{
                    fileEditor.writeReviewFile("Files\\Reviews\\" + activeUser + "-" + acc + ".txt", activeUser,
                                                acc, rating.getSelectedItem().toString(),dateText.getText(), reviewTextArea.getText());
                    frame.dispose();
                    infoWindow newGui = new infoWindow();
                }
            }else if(e.getSource()==back){
                frame.dispose();
                infoWindow newGui = new infoWindow();
            }
        }
    }
