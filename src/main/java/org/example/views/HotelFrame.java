package org.example.views;

import org.example.models.*;
import org.example.services.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class HotelFrame extends ProjectFrame {

    protected JButton back;
    protected JButton hotel1;
    protected JButton hotel2;

    public HotelFrame(String title, String name) {
        super(title);
        this.setBounds(100, 100, 643, 432);
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        back = new JButton("Back");
        back.setFont(new Font("Tahoma", Font.PLAIN, 15));
        back.setBounds(450, 300, 70, 25);
        back.setBackground(Color.MAGENTA);
        this.getContentPane().add(back);
        back.setVisible(true);
        JLabel titleLabel = new JLabel("Here are your options:");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        titleLabel.setBounds(200, 40, 400, 40);
        this.getContentPane().add(titleLabel);
        titleLabel.setVisible(true);
        HotelService hotelService = new HotelService();
        ArrayList<Hotel> hotel = hotelService.getAll();
        //JList list = new JList();
        String hotels[] = new String[2];
        if (name == "Cluj") {
            int j = 1;
            for (int i = 0; i < hotel.size(); i++) {
                if (hotel.get(i).getWherefrom() == 1) {
                    hotels[j] = hotel.get(i).getHotel_name();
                    j--;
                }
            }
            //list = new JList(hotels);
        } else {
            if (name == "Oradea") {
                int j = 0;
                for (int i = 0; i < hotel.size(); i++) {
                    if (hotel.get(i).getWherefrom() == 2) {
                        hotels[j] = hotel.get(i).getHotel_name();
                        j++;
                    }

                    //list = new JList(hotels);
                }
            } else {
                if (name == "Brasov") {
                    int j = 0;
                    for (int i = 0; i < hotel.size(); i++) {
                        if (hotel.get(i).getWherefrom() == 3) {
                            hotels[j] = hotel.get(i).getHotel_name();
                            j++;
                        }
                    }
                    //list = new JList(hotels);

                } else {
                    int j = 0;
                    for (int i = 0; i < hotel.size(); i++) {
                        if (hotel.get(i).getWherefrom() == 4) {
                            hotels[j] = hotel.get(i).getHotel_name();
                            j++;
                        }
                    }
                    //list = new JList(hotels);

                }
            }
        }
        hotel1 = new JButton(hotels[0]);
        hotel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hotel1.setBounds(120, 175, 150, 20);
        hotel1.setBackground(Color.MAGENTA);
        this.getContentPane().add(hotel1);
        hotel1.setVisible(true);
        hotel2 = new JButton(hotels[1]);
        hotel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        hotel2.setBounds(120, 200, 150, 20);
        hotel2.setBackground(Color.MAGENTA);
        this.getContentPane().add(hotel2);
        hotel2.setVisible(true);
        //this.getContentPane().add(list);


    }

    public void setBackButtonActionListener(ActionListener a) {
        back.addActionListener(a);
    }

    public void setHotel1ButtonActionListener(ActionListener a) {
        hotel1.addActionListener(a);
    }

    public void setHotel2ButtonActionListener(ActionListener a) {
        hotel2.addActionListener(a);
    }


    @Override
    public void goBack() {

    }
}
