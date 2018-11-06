import javax.swing.*; 
import java.awt.event.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TabbedPaneExample {  
JFrame f; 

TabbedPaneExample(){  
    f=new JFrame();  
    f.setSize(400,400); 
    //JTextArea ta=new JTextArea(200,200);
    JLabel l1, l2, l3;
    l1=new JLabel("First Label.");  
    l1.setBounds(50,50, 100,30);  
    l2=new JLabel("Second Label.");  
    l2.setBounds(50,100, 100,30);  
    l3 = new JLabel("third Label");
    l3.setBounds(50, 70, 100, 30);

    JPanel p1=new JPanel();  
    //p1.add(ta);  
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel(); 
    JButton p4=new JButton("Hit me");

    p1.add(l1); p2.add(l2); p3.add(l3); 
    JTabbedPane tp=new JTabbedPane(JTabbedPane.TOP);  
    //tp.setBounds(50,50,200,200); 
    tp.setBounds(f.getLocation().x+2, f.getLocation().y+2, f.getWidth()-100, f.getHeight()-100);
    tp.add("Sorter",p1);  
    tp.add("Calculator",p2);
    tp.add("Games",p3); 
    tp.add("PlaceHolder", p4);  


    tp.addChangeListener(new ChangeListener() {

        // This method is called whenever the selected tab changes

        public void stateChanged(ChangeEvent evt) {

            JTabbedPane tabbedPane = (JTabbedPane)evt.getSource();

            

            // Get current tab

            int tab = tabbedPane.getSelectedIndex();

            System.out.println("Tab is: " + (tab+1));

        }

    });

    f.add(tp);  
     
    f.setLayout(null);  
    f.setVisible(true);  
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}  


public static void main(String[] args) {  
    new TabbedPaneExample(); 
}}  
