package org.hotelsimulator.views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FinalFrame extends ProjectFrame {

    private JTextField totalField;
    private JTextField sumField;
    private JButton showButton;
    private JButton abort;

    public FinalFrame(String title) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("The results for your preferrences");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        titleLabel.setBounds(200, 21, 300, 40);
        this.getContentPane().add(titleLabel);

        JLabel label = new JLabel("Thank you for choosing us <3");
        label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label.setBounds(200, 300, 300, 40);
        this.getContentPane().add(label);
        label.setVisible(true);

        showButton = new JButton("SHOW");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        showButton.setBounds(270, 110, 85, 21);
        showButton.setBackground(Color.MAGENTA);
        this.getContentPane().add(showButton);

        abort = new JButton("CHANGED MY MIND");
        abort.setFont(new Font("Tahoma", Font.PLAIN, 12));
        abort.setBounds(240, 280, 150, 21);
        abort.setBackground(Color.MAGENTA);
        this.getContentPane().add(abort);

        totalField = new JTextField();
        totalField.setBounds(105, 160, 450, 35);
        totalField.setBackground(Color.pink);
        this.getContentPane().add(totalField);
        totalField.setColumns(2);

        sumField = new JTextField();
        sumField.setBounds(290, 210, 45, 30);
        sumField.setBackground(Color.pink);
        this.getContentPane().add(sumField);
        sumField.setColumns(2);
        this.setVisible(true);

    }

    public void setShowButtonButtonActionListener(ActionListener a) {
        showButton.addActionListener(a);
    }

    public void setAbortButtonActionListener(ActionListener a) {
        abort.addActionListener(a);
    }

    public double getTotalField() {
        return Double.parseDouble(totalField.getText());
    }

    public void setTotalField(String totalField) {
        this.totalField.setText(String.valueOf(totalField));
    }

    public double getSumField() {
        return Double.parseDouble(sumField.getText());
    }

    public void setSumField(Double sumField) {
        this.sumField.setText(String.valueOf(sumField));
    }

    @Override
    public void goBack() {

    }
}
