package org.hotelsimulator.services;

import org.hotelsimulator.models.Hotel;
import org.hotelsimulator.repository.HotelRepository;

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
