package org.example.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

public class LogFrame extends ProjectFrame {
    protected JButton Next;
    protected JTextField name;

    public LogFrame(String title) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel titlelabel = new JLabel("Please log in");
        titlelabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        titlelabel.setBounds(230, 60, 200, 25);
        this.getContentPane().add(titlelabel);
        JLabel titlelabel1 = new JLabel("Enter your name here:");
        titlelabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        titlelabel1.setBounds(160, 140, 300, 25);
        this.getContentPane().add(titlelabel1);
        name = new JTextField();
        name.setBounds(160, 190, 300, 35);

        this.getContentPane().add(name);
        name.setColumns(2);
        Next = new JButton("Next");
        Next.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Next.setBounds(400, 280, 100, 30);
        Next.setBackground(Color.MAGENTA);
        this.getContentPane().add(Next);
        Next.setVisible(true);

        this.setVisible(true);
    }

    public void setNextButtonActionListener(ActionListener a) {
        Next.addActionListener(a);
    }

    public String getName() {
        return name.getText();
    }

    public void setName(String nameField) {
        this.name.setText(String.valueOf(name));
    }

    @Override
    public void goBack() {

    }
}
