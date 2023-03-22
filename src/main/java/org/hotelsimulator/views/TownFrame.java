package org.hotelsimulator.views;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class TownFrame extends ProjectFrame {

    protected JButton town1;
    protected JButton town2;
    protected JButton town3;
    protected JButton town4;

    public TownFrame(String title) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel titleLabel = new JLabel("Please choose your preferred city :)");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(150, 40, 400, 40);
        this.getContentPane().add(titleLabel);
        town1 = new JButton("Cluj");
        town1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        town1.setBounds(135, 130, 100, 20);
        town1.setBackground(Color.MAGENTA);
        this.getContentPane().add(town1);
        town2 = new JButton("Oradea");
        town2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        town2.setBounds(180, 155, 100, 20);
        town2.setBackground(Color.MAGENTA);
        this.getContentPane().add(town2);
        town3 = new JButton("Brasov");
        town3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        town3.setBounds(225, 180, 100, 20);
        town3.setBackground(Color.MAGENTA);
        this.getContentPane().add(town3);
        town4 = new JButton("Sibiu");
        town4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        town4.setBounds(270, 205, 100, 20);
        town4.setBackground(Color.MAGENTA);
        this.getContentPane().add(town4);
        JLabel titleLabel1 = new JLabel("Now we will find you a hotel, just wait !!");
        titleLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel1.setBounds(135, 270, 400, 40);
        this.getContentPane().add(titleLabel1);
        this.setVisible(true);
    }

    public void setTown1ButtonActionListener(ActionListener a) {
        town1.addActionListener(a);
    }

    public void setTown2ButtonActionListener(ActionListener a) {
        town2.addActionListener(a);
    }

    public void setTown3ButtonActionListener(ActionListener a) {
        town3.addActionListener(a);
    }

    public void setTown4ButtonActionListener(ActionListener a) {
        town4.addActionListener(a);
    }

    @Override
    public void goBack() {

    }
}
