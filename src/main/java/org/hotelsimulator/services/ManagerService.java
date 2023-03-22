package org.hotelsimulator.services;

import org.hotelsimulator.models.Manager;
import org.hotelsimulator.repository.ManagerRepository;

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
