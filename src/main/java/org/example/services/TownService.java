package org.example.services;

import org.example.models.Town;
import org.example.repository.TownRepository;

import java.util.ArrayList;
import java.util.List;

public class TownService {

    private TownRepository townRepository;

    public TownService() {
        this.townRepository = new TownRepository();
    }

    public ArrayList<Town> getAll() {
        return townRepository.get();
    }
}
