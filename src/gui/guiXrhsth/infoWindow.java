package gui.guiXrhsth;

import api.fileEditor;
import gui.guiViewAccom;
import gui.viewReviews;

import javax.swing.*;
import static gui.guiParoxou.MainMenuParoxou.acc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Iterator;

import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.accompath;

public class infoWindow implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel totalReviewAvg;
    JLabel username;
    JLabel label;
    JComboBox<String> box;
    JButton view;
    JButton delete;
    JButton edit;
    JButton button;
    String[] myReviews;
    Integer i;
    float reviewAvg;
    public static String reviewPath;
    private static final DecimalFormat df = new DecimalFormat("0.0");
    public infoWindow(){
        frame = new JFrame();
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        username = new JLabel();
        username.setText("Username: "+ activeUser);
        username.setBounds(20,5,150,30);
        panel.add(username);

        label = new JLabel("Οι αξιολογήσεις μου:");
        label.setBounds(20,55,150,30);
        panel.add(label);

        box = new JComboBox<>();
        box.setBounds(25,80,440,25);

        File directoryPath = new File("Files\\Reviews");
        myReviews = directoryPath.list();
        float totalReview=0;
        float numberofReviews=0;

        if (myReviews != null) {
            for (i = 0; i < myReviews.length; i++) {
                try {
                    if(fileEditor.read("Files\\Reviews\\"+myReviews[i],1).equals(activeUser)) {
                        String path = "Files\\Accommodations\\" + fileEditor.read("Files\\Reviews\\"+myReviews[i],2)+".txt";
                        box.addItem(myReviews[i].substring(0, myReviews[i].length() - 4) + "/" +fileEditor.read(path,3)
                                    + "/" +fileEditor.read(path,5)+ "/" +fileEditor.read("Files\\Reviews\\"+myReviews[i],3));
                        totalReview = totalReview + Integer.valueOf(fileEditor.read("Files\\Reviews\\" + myReviews[i], 3));
                        numberofReviews++;
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        panel.add(box);
        if(numberofReviews==0){
            reviewAvg = 0;
        }else {
            reviewAvg = totalReview / numberofReviews;
        }

        totalReviewAvg = new JLabel();
        totalReviewAvg.setText("Ο μέσος όρος των αξιολογήσεων είναι: "+df.format(reviewAvg));
        totalReviewAvg.setBounds(20,30,300,30);
        panel.add(totalReviewAvg);

        button = new JButton("Πίσω");
        button.setBounds(150,210,180,30);
        button.addActionListener(this);
        panel.add(button);

        view = new JButton("Προβολή καταχώρησης");
        view.setBounds(150,110,180,30);
        view.addActionListener(this);
        panel.add(view);

        edit = new JButton("Επεξεργασία αξιολόγησης");
        edit.setBounds(50,160,180,30);
        edit.addActionListener(this);
        panel.add(edit);

        delete = new JButton("Διαγραφή αξιολόγησης");
        delete.setBounds(270,160,180,30);
        delete.addActionListener(this);
        panel.add(delete);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            frame.dispose();
            MainMenuXrhsth newGui = new MainMenuXrhsth();
        }else if(e.getSource()==view){
            try {
                acc = box.getSelectedItem().toString();
                String[] split = acc.split("/");
                acc=split[0];
                acc=fileEditor.read("Files\\Reviews\\"+acc+".txt",2);
                accompath ="Files\\Accommodations\\"+acc+".txt";
                frame.dispose();
                guiViewAccom myGui = new guiViewAccom();
                myGui.frame.setVisible(true);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }else if(e.getSource()==edit){
            frame.dispose();
            acc = box.getSelectedItem().toString();
            String[] split = acc.split("/");
            acc=split[0];
            reviewPath = "Files\\Reviews\\"+acc+".txt";
            try {
                acc=fileEditor.read(reviewPath,2);
                editReview neyGui = new editReview();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }else if(e.getSource()==delete){
            acc = box.getSelectedItem().toString();
            String[] split = acc.split("/");
            acc=split[0];
            reviewPath = "Files\\Reviews\\"+acc+".txt";
            try {
                Files.delete(Paths.get(reviewPath));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();
            infoWindow newGui = new infoWindow();
        }
    }
}