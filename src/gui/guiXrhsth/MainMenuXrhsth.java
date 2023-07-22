package gui.guiXrhsth;
import gui.GUIlogin;
import gui.guiViewAccom;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import static gui.GUIlogin.activeUser;
import static gui.guiParoxou.MainMenuParoxou.accompath;
import static gui.guiParoxou.MainMenuParoxou.acc;

public class MainMenuXrhsth extends JFrame implements ActionListener {
    public JFrame frame;
    JPanel panel;
    JButton search;
    JButton dash;
    public  String[] content;
    public  int i;
    JComboBox accBox;
    JButton viewAccom;
    JButton disconnect;
    JLabel menu;

    public MainMenuXrhsth() {
        frame = new JFrame();
        frame.setSize(600,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        menu = new JLabel("Κεντρικό μενού");
        menu.setBounds(250, 20, 200, 25);
        panel.add(menu);

        search = new JButton("Αναζήτηση");
        search.setBounds(200,70,200,25);
        panel.add(search);
        search.addActionListener(this);


        dash = new JButton("Dashboard");
        dash.setBounds(200,130,200,25);
        panel.add(dash);
        dash.addActionListener(this);

        JLabel nameK = new JLabel("Όλα τα καταλύματα :");
        nameK.setBounds(250, 180, 200, 25);
        panel.add(nameK);

        File directoryPath = new File("Files\\Accommodations");
        content = directoryPath.list();

        if (content != null) {
            accBox = new JComboBox<>();
            accBox.setBounds(50, 230, 200, 25);
            for ( i = 0; i < content.length; i++) {
                accBox.addItem(content[i].substring(0,content[i].length() - 4));
            }
            panel.add(accBox);
        }

        viewAccom = new JButton("Προβολή καταχώρησης");
        viewAccom.setBounds(300, 230, 200, 25);
        panel.add(viewAccom);
        viewAccom.addActionListener(this);

        disconnect = new JButton("Αποσύνδεση");
        disconnect.setBounds(200, 330, 200, 25);
        panel.add(disconnect);
        disconnect.addActionListener(this);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            frame.dispose();
            searchWindow sr = new searchWindow();
            sr.frame.setVisible(true);
        }else if(e.getSource()==dash){
            frame.dispose();
            infoWindow dashboard = new infoWindow();
            dashboard.frame.setVisible(true);
        }else if (e.getSource() == viewAccom){
            acc = accBox.getSelectedItem().toString();
            accompath = "Files\\Accommodations\\"+acc+".txt";
            frame.dispose();
            guiViewAccom myGui = null;
            try {
                myGui = new guiViewAccom();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            myGui.frame.setVisible(true);
        } else if(e.getSource() == disconnect){
            frame.dispose();
            activeUser = null;
            GUIlogin myGui = new GUIlogin();
            myGui.frame.setVisible(true);
        }
    }
}
