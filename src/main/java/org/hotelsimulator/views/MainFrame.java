package org.hotelsimulator.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

public class MainFrame extends ProjectFrame {
    protected JButton LogIn;
    protected JButton SignIn;

    public MainFrame(String title) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        JLabel titleLabel = new JLabel("WELCOME TO MY APP <3");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(200, 70, 400, 40);
        this.getContentPane().add(titleLabel);
        JLabel titleLabel1 = new JLabel("Would you like to become our user ?");
        titleLabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel1.setBounds(150, 160, 400, 40);
        this.getContentPane().add(titleLabel1);
        JLabel owner = new JLabel("Owned by Fuia Daria");
        owner.setFont(new Font("Tahoma", Font.PLAIN, 15));
        owner.setBounds(90, 320, 200, 25);
        this.getContentPane().add(owner);
        LogIn = new JButton("Log in");
        LogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        LogIn.setBounds(400, 280, 100, 30);
        LogIn.setBackground(Color.MAGENTA);
        this.getContentPane().add(LogIn);
        LogIn.setVisible(true);
        SignIn = new JButton("Sign in");
        SignIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SignIn.setBounds(100, 280, 100, 30);
        SignIn.setBackground(Color.MAGENTA);
        this.getContentPane().add(SignIn);
        SignIn.setVisible(true);
        this.setVisible(true);
    }

    public void setSignInButtonActionListener(ActionListener a) {
        SignIn.addActionListener(a);
    }

    public void setLogInButtonActionListener(ActionListener a) {
        LogIn.addActionListener(a);
    }


    @Override
    public void goBack() {

    }
}
