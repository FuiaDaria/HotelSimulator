package org.hotelsimulator.services;

import org.hotelsimulator.models.Rooms;
import org.hotelsimulator.repository.RoomRepository;

import java.util.ArrayList;

public class RoomService {
    private RoomRepository roomRepository;

    public RoomService() {
        this.roomRepository = new RoomRepository();
    }

    public ArrayList<Rooms> getAll() {
        return roomRepository.get();
    }
}
