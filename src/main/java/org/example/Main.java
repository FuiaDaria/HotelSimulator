package org.example;

//import org.example.models.Manager;
import org.example.controllers.LogController;
import org.example.controllers.MainController;
import org.example.services.*;
//import org.example.models.Hotel;
//import org.example.models.Rooms;
import org.example.models.*;
import org.example.views.*;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*TownService townService = new TownService();
        ArrayList<Town> towns = townService.getAll();
        towns.forEach(System.out::println);

        ClientService clientService = new ClientService();
        ArrayList<Client> clients = clientService.getAll();
        clients.forEach(System.out::println);

        ManagerService managerService = new ManagerService();
        ArrayList<Manager> managers = managerService.getAll();
        managers.forEach(System.out::println);

        HotelService hotelService = new HotelService();
        ArrayList<Hotel> hotels = hotelService.getAll();
        hotels.forEach(System.out::println);

        RoomService roomService = new RoomService();
        ArrayList<Rooms> rooms = roomService.getAll();
        rooms.forEach(System.out::println);

        TypeService typeService = new TypeService();
        ArrayList<Type> types = typeService.getAll();
        types.forEach(System.out::println);*/

        //new MainController(new MainFrame("Main"), false);
        //new LogController(new LogFrame("Log"), false);
        new FinalFrame("Gata");


    }
}