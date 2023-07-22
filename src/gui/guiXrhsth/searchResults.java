package gui.guiXrhsth;

import api.fileEditor;

import static gui.guiParoxou.MainMenuParoxou.acc;
import static  gui.guiParoxou.MainMenuParoxou.accompath;
import gui.guiViewAccom;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;


public class searchResults implements ActionListener {
    JFrame frame;
    JPanel panel;
    JComboBox box;
    JLabel label;
    JButton button1;
    JButton button2;
    public String[] allrev;

    public searchResults() throws FileNotFoundException {
        frame = new JFrame();
        frame.setSize(330,230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        label = new JLabel("Λίστα αποτελεσμάτων:");
        label.setBounds(20,10,200,25);
        panel.add(label);

        File directoryPath = new File("Files\\Reviews");
        allrev = directoryPath.list();

        int totalA=0;
        float totalS=0;

        box = new JComboBox();
        box.setBounds(10,50,295,25);
        for(String r:searchWindow.result){
            if (allrev != null) {
                for (int i = 0; i < allrev.length; i++) {
                    if (fileEditor.read("Files\\Reviews\\"+allrev[i],2).equals(fileEditor.read("Files\\Reviews\\"+allrev[i],2))){
                        totalA=totalA+1;
                        totalS=totalS+Integer.valueOf(fileEditor.read("Files\\Reviews\\"+allrev[i],3));
                    }
                }
            }
            box.addItem(fileEditor.read(r,2)+"/"+fileEditor.read(r,3)+"/"+fileEditor.read(r,5)+"/"+totalS/totalA);
        }
        panel.add(box);

        button1 = new JButton("Πίσω");
        button1.setBounds(110,105,100,25);
        button1.addActionListener(this);
        panel.add(button1);

        button2 = new JButton("Προβολή καταχώρησης");
        button2.setBounds(60,145,200,25);
        button2.addActionListener(this);
        panel.add(button2);

        frame.setVisible(true);
        panel.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            frame.dispose();
            searchWindow newGui = new searchWindow();
        } else if(e.getSource()==button2){
            frame.dispose();
            acc = box.getSelectedItem().toString();
            String[] split = acc.split("/");
            acc=split[0];
            accompath= "Files\\Accommodations\\"+acc+".txt";
            guiViewAccom myGui = null;
            try {
                myGui = new guiViewAccom();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        }
    }
}