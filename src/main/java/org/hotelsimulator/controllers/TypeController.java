package org.hotelsimulator.controllers;

import org.hotelsimulator.utils.FrameStack;
import org.hotelsimulator.views.*;
import org.hotelsimulator.models.*;

import java.util.ArrayList;

import org.hotelsimulator.services.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeController extends AbstractController {
    public static int hotel_id;
    int v[] = {5, 3, 4, 7, 0, 2, 1, 6};
    String s = "yes";
    RoomService roomsService = new RoomService();
    ArrayList<Rooms> rooms = roomsService.getAll();
    HotelService hotelService = new HotelService();
    ArrayList<Hotel> hotels = hotelService.getAll();

    public TypeController(TypeFrame frame, boolean hasBackButton, int hotel_id) {
        super(frame, hasBackButton);
        this.hotel_id = hotel_id;
        frame.setBackButtonActionListener(new BackButtonActionListener());
        frame.setType1ButtonActionListener(new Type1ButtonActionListener());
        frame.setType2ButtonActionListener(new Type2ButtonActionListener());
        frame.setType3ButtonActionListener(new Type3ButtonActionListener());
        frame.setType4ButtonActionListener(new Type4ButtonActionListener());

    }

    private class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameStack.getInstance().pop();
        }
    }

    private class Type1ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double price = 0;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoom_hotel() == TypeController.hotel_id && rooms.get(i).getRoom_type() == 1 && !(rooms.get(i).getAvailability() == s)) {
                    price = hotels.get(v[hotel_id - 1]).getPrice_per_room() * 0.75;

                    new FinalController(new FinalFrame("Result"), false, price);
                }

            }
            new FinalController(new FinalFrame("Result"), false, price);
        }
    }

    private class Type2ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double price = 0;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoom_hotel() == TypeController.hotel_id && rooms.get(i).getRoom_type() == 2) {
                    price = hotels.get(v[hotel_id - 1]).getPrice_per_room() * 1;

                    new FinalController(new FinalFrame("Result"), false, price);
                }

            }
            new FinalController(new FinalFrame("Result"), false, price);
        }
    }

    private class Type3ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double price = 0;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoom_hotel() == TypeController.hotel_id && rooms.get(i).getRoom_type() == 3) {
                    price = hotels.get(v[hotel_id - 1]).getPrice_per_room() * 1.25;

                    new FinalController(new FinalFrame("Result"), false, price);
                }

            }
            new FinalController(new FinalFrame("Result"), false, price);
        }
    }

    private class Type4ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double price = 0;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i).getRoom_hotel() == TypeController.hotel_id && rooms.get(i).getRoom_type() == 4) {
                    price = hotels.get(v[hotel_id - 1]).getPrice_per_room() * 1.5;

                    new FinalController(new FinalFrame("Result"), false, price);
                }

            }
            new FinalController(new FinalFrame("Result"), false, price);
        }
    }
}
