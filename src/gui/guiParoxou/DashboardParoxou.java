package gui.guiParoxou;

import api.fileEditor;
import gui.guiViewAccom;
import gui.guiXrhsth.MainMenuXrhsth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import static api.fileEditor.read;
import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.acc;
import static gui.guiParoxou.MainMenuParoxou.accompath;

public class DashboardParoxou extends JFrame implements ActionListener {
    public JFrame frame;
    JPanel panel;
    public  String[] allacc;

    public  String[] allrev;
    JComboBox accBox;
    JButton viewAccom;

    JButton back;
    private static final DecimalFormat df = new DecimalFormat("0.0");


    int i;
    int j;
    public DashboardParoxou() throws FileNotFoundException {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel total = new JLabel("Συνολικός αριθμός αξιολογήσεων των καταλυμάτων σας : ");
        total.setBounds(40, 20, 350, 25);
        panel.add(total);

        int totalA=0;
        float totalS=0;

        JLabel uracc = new JLabel("Τα καταλύματά σας :");
        uracc.setBounds(225, 120, 350, 25);
        panel.add(uracc);

        File directoryPath = new File("Files\\Accommodations");
        allacc = directoryPath.list();
        if ( allacc!=null){
            accBox = new JComboBox<>();
            accBox.setBounds(100, 170, 350, 25);
            for (i = 0; i < allacc.length; i++) {

                if (fileEditor.read("Files\\Accommodations\\" + allacc[i], 1).equals(activeUser)){
                    int totalA2=0;
                    int totalS2=0;

                    File directoryPath2 = new File("Files\\Reviews");
                    allrev = directoryPath2.list();
                    if (allrev!=null){
                        for (j=0; j<allrev.length; j++){
                            if (fileEditor.read("Files\\Accommodations\\"+allacc[i],2).equals(fileEditor.read("Files\\Reviews\\"+allrev[j],2))){
                                totalA=totalA+1;
                                totalA2=totalA2+1;
                                totalS=totalS+Integer.valueOf(fileEditor.read("Files\\Reviews\\"+allrev[j],3));
                                totalS2=totalS2+Integer.valueOf(fileEditor.read("Files\\Reviews\\"+allrev[j],3));
                            }
                        }
                    }

                    if(totalA2!=0){
                        totalS2 = totalS2/totalA2;
                    }

                    String path = "Files\\Accommodations\\" + allacc[i];
                    accBox.addItem(allacc[i].substring(0, allacc[i].length() - 4)+ "/" +fileEditor.read(path,3)
                            + "/" +fileEditor.read(path,5)+ "/"+ String.valueOf(df.format(totalS2)));


                }
            }
            panel.add(accBox);
        }

        viewAccom = new JButton("Προβολή καταχώρησης");
        viewAccom.setBounds(170, 220, 250, 25);
        panel.add(viewAccom);
        viewAccom.addActionListener(this);


        back = new JButton("Επιστροφή στο κεντρικό μενού");
        back.setBounds(170, 280, 250, 25);
        panel.add(back);
        back.addActionListener(this);


        if(totalA!=0){
            totalS = totalS/totalA;
        }

        JLabel total1 = new JLabel(String.valueOf(totalA));
        total1.setBounds(450, 20, 120, 25);
        panel.add(total1);

        JLabel name = new JLabel("Μέσος όρος αξιολογήσεων των καταλυμάτων : ");
        name.setBounds(40, 70, 350, 25);
        panel.add(name);

        JLabel total2 = new JLabel(String.valueOf(df.format(totalS)));
        total2.setBounds(450, 70, 120, 25);
        panel.add(total2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAccom){
            acc = accBox.getSelectedItem().toString();
            String[] split = acc.split("/");
            acc=split[0];
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
        if (e.getSource()==back){
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

