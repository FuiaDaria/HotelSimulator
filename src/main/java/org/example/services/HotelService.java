package org.example.services;

import org.example.models.Hotel;
import org.example.repository.HotelRepository;

import java.util.ArrayList;

public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService() {
        this.hotelRepository = new HotelRepository();
    }

    public ArrayList<Hotel> getAll() {
        return hotelRepository.get();
    }
}
