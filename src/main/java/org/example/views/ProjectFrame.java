package org.example.views;

import org.example.services.Constants;
import org.example.utils.FrameStack;

import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class ProjectFrame extends JFrame implements ProjectFrame_1 {

    protected JPanel contentPanel;

    public ProjectFrame(String title) {
        FrameStack.getInstance().push(this);
        setTitle(title);
        setSize(Constants.Frames.WIDTH, Constants.Frames.HEIGHT);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setBackground(Color.RED);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void setBackButtonActionListener(ActionListener a) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Back");
        buttonPanel.add(backButton);
        this.add(buttonPanel, BorderLayout.NORTH);
        backButton.addActionListener(a);
    }


}
