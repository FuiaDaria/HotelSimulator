package org.example.services;

import org.example.models.Rooms;
import org.example.repository.RoomRepository;

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
