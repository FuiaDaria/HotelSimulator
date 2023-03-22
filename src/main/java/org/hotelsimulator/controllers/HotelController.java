package org.hotelsimulator.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hotelsimulator.views.*;
import org.hotelsimulator.utils.FrameStack;

public class HotelController extends AbstractController {
    public static int town_id;

    public HotelController(HotelFrame frame, boolean hasBackButton, int town_id) {
        super(frame, hasBackButton);
        this.town_id = town_id;
        frame.setBackButtonActionListener(new BackButtonActionListener());
        frame.setHotel1ButtonActionListener(new Hotel1ButtonActionListener());
        frame.setHotel2ButtonActionListener(new Hotel2ButtonActionListener());
    }

    private class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }

    private class Hotel1ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new TypeController(new TypeFrame("Room Types", 2 * town_id - 1), true, 2 * town_id - 1);
        }
    }

    private class Hotel2ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new TypeController(new TypeFrame("Room Types", 2 * town_id), true, 2 * town_id);
        }
    }
}

