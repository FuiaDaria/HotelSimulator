package org.hotelsimulator.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.hotelsimulator.models.*;
import org.hotelsimulator.utils.FrameStack;
import org.hotelsimulator.views.*;
import org.hotelsimulator.services.*;

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
