package org.hotelsimulator.controllers;

import org.hotelsimulator.models.*;
import org.hotelsimulator.services.*;

import java.util.ArrayList;

import org.hotelsimulator.views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalController extends AbstractController {
    public static double price;
    FinalFrame view;
    ClientService clientService = new ClientService();
    ArrayList<Client> clients = clientService.getAll();

    public FinalController(FinalFrame view, boolean hasBackButton, double price) {
        super(view, hasBackButton);
        this.view = view;
        this.price = price;
        view.setShowButtonButtonActionListener(new ShowButtonButtonActionListener());
        view.setAbortButtonActionListener(new abortButtonActionListener());

    }

    private class ShowButtonButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (FinalController.price == 0) {
                view.setTotalField("We are sorry, but we did not find anything that corresponds to your requirements :(");
                //System.out.println("We are sorry, but we did not find anything that corresponds to your requirements :(");
            } else {
                /*System.out.println("We are pleased to let you know that you have booked the room.");
                System.out.println("Your total is of ");
                System.out.println(FinalController.price);*/
                view.setTotalField("We are pleased to let you know that you have booked the room. Your total is of ");
                view.setSumField(FinalController.price);
            }
        }
    }

    private class abortButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientService.deleteClient(20);
        }
    }

}

