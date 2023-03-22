package org.example.services;

import org.example.models.Manager;
import org.example.repository.ManagerRepository;

import java.util.ArrayList;

public class ManagerService {
    private ManagerRepository managerRepository;

    public ManagerService() {
        this.managerRepository = new ManagerRepository();
    }

    public ArrayList<Manager> getAll() {
        return managerRepository.get();
    }
}
