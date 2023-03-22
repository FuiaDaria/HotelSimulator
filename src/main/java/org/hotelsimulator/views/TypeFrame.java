package org.hotelsimulator.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TypeFrame extends ProjectFrame {
    protected JButton back;
    protected JButton type1;
    protected JButton type2;
    protected JButton type3;
    protected JButton type4;

    public TypeFrame(String title, int hotel_id) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel titleLabel = new JLabel("Choose the room type that you want to book");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(100, 70, 400, 40);
        this.getContentPane().add(titleLabel);
        titleLabel.setVisible(true);

        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.setBounds(440, 300, 80, 20);
        back.setBackground(Color.MAGENTA);
        this.getContentPane().add(back);
        back.setVisible(true);

        type1 = new JButton("Single");
        type1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        type1.setBounds(250, 150, 120, 20);
        type1.setBackground(Color.MAGENTA);
        this.getContentPane().add(type1);
        type1.setVisible(true);
        type2 = new JButton("Double");
        type2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        type2.setBounds(250, 180, 120, 20);
        type2.setBackground(Color.MAGENTA);
        this.getContentPane().add(type2);
        type2.setVisible(true);
        type3 = new JButton("Triple");
        type3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        type3.setBounds(250, 210, 120, 20);
        type3.setBackground(Color.MAGENTA);
        this.getContentPane().add(type3);
        type3.setVisible(true);
        type4 = new JButton("Apartament");
        type4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        type4.setBounds(250, 240, 120, 20);
        type4.setBackground(Color.MAGENTA);
        this.getContentPane().add(type4);
        type4.setVisible(true);
    }

    public void setBackButtonActionListener(ActionListener a) {
        back.addActionListener(a);
    }

    public void setType1ButtonActionListener(ActionListener a) {
        type1.addActionListener(a);
    }

    public void setType2ButtonActionListener(ActionListener a) {
        type2.addActionListener(a);
    }

    public void setType3ButtonActionListener(ActionListener a) {
        type3.addActionListener(a);
    }

    public void setType4ButtonActionListener(ActionListener a) {
        type4.addActionListener(a);
    }

    @Override
    public void goBack() {

    }
}
