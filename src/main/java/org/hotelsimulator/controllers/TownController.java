package org.hotelsimulator.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hotelsimulator.views.*;

public class TownController extends AbstractController {
    public TownController(TownFrame frame, boolean hasBackButton) {
        super(frame, hasBackButton);
        frame.setTown1ButtonActionListener(new Town1ButtonActionListener());
        frame.setTown2ButtonActionListener(new Town2ButtonActionListener());
        frame.setTown3ButtonActionListener(new Town3ButtonActionListener());
        frame.setTown4ButtonActionListener(new Town4ButtonActionListener());
    }

    private class Town1ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new HotelController(new HotelFrame("Hotels", "Cluj"), true, 1);
        }
    }

    private class Town2ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new HotelController(new HotelFrame("Hotels", "Oradea"), true, 2);
        }
    }

    private class Town3ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new HotelController(new HotelFrame("Hotels", "Brasov"), true, 3);
        }
    }

    private class Town4ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new HotelController(new HotelFrame("Hotels", "Sibiu"), true, 4);
        }
    }
}
