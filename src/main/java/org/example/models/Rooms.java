package org.example.models;

public class Rooms {
    private int room_id;
    private int room_hotel;
    private int room_type;
    private String availability;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getRoom_hotel() {
        return room_hotel;
    }

    public void setRoom_hotel(int room_hotel) {
        this.room_hotel = room_hotel;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "room_id=" + room_id +
                ", room_hotel=" + room_hotel +
                ", room_type=" + room_type +
                ", availability='" + availability + '\'' +
                '}';
    }
}
