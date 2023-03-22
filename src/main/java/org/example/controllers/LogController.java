package org.example.controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.example.models.*;
import org.example.repository.*;
import org.example.utils.FrameStack;
import org.example.views.*;
import org.example.services.*;

import javax.swing.*;

public class LogController extends AbstractController {
    ClientService clientService = new ClientService();
    ArrayList<Client> clients = clientService.getAll();
    LogFrame frame;

    public LogController(LogFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        this.frame = frame;
        frame.setNextButtonActionListener(new NextButtonActionListener());
        frame.setBackButtonActionListener(new BackButtonActionListener());
    }

    private class NextButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientService.addClient(frame.getName());
            System.out.println(frame.getName());
            new TownController(new TownFrame("Towns"), false);
        }
    }

    private class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }
}
