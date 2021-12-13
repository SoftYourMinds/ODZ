package com.company.classes;
import  java.awt.*;
import  java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JLabel  headingLable = new JLabel("<html><span style ='font-size:20px;  font-weight: 500;'><font color = 'green'>Welcome to Cinder Books Shop</font></span></html>");
    private JLabel findBooksLabel = new JLabel("<html><div style ='vertical-align: middle;'><span style ='font-size:14px; vertical-align: middle;'> Find books: <span style= 'font-size: 10px; vertical-align: middle;'>from</span> </span></div></html>");
    private JSpinner minOldSpinner = new JSpinner();
    private JLabel toMaxLabel = new JLabel("to" );
    private JSpinner maxOldSpinner = new JSpinner();
    private JButton findButton = new JButton("GO");

    private JLabel findBooksCoastAndAgeLabel = new JLabel("<span style: font-size: 14px> Find books:");
     public SimpleGUI() {
         super("CinderBookShop");
         this.setBounds(100, 100, 600, 300);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JPanel grid = new JPanel(new GridLayout(2,1,5,0));
            JPanel flow1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            flow1.add(headingLable);
            grid.add(flow1);
            JPanel flow2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            flow2.add(findBooksLabel);
            flow2.add(minOldSpinner);
            flow2.add(toMaxLabel);
            flow2.add(maxOldSpinner);
            flow2.add(findButton);
            flow2.setVisible(true);
            grid.add(flow2);
            grid.setVisible(true);
        this.add(grid);
     }

}
