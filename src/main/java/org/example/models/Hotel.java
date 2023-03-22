package org.example.models;

public class Hotel {
    private int hotel_id;
    private String hotel_name;
    private int nr_of_rooms;
    private int wherefrom;
    private int price_per_room;

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getNr_of_rooms() {
        return nr_of_rooms;
    }

    public void setNr_of_rooms(int nr_of_rooms) {
        this.nr_of_rooms = nr_of_rooms;
    }

    public int getWherefrom() {
        return wherefrom;
    }

    public void setWherefrom(int wherefrom) {
        this.wherefrom = wherefrom;
    }

    public int getPrice_per_room() {
        return price_per_room;
    }

    public void setPrice_per_room(int price_per_room) {
        this.price_per_room = price_per_room;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_id=" + hotel_id +
                ", hotel_name='" + hotel_name + '\'' +
                ", nr_of_rooms=" + nr_of_rooms +
                ", wherefrom=" + wherefrom +
                ", price_per_room=" + price_per_room +
                '}';
    }
}
