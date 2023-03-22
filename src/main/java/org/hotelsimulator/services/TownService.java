package org.hotelsimulator.services;

import org.hotelsimulator.models.Town;
import org.hotelsimulator.repository.TownRepository;

import java.util.ArrayList;

public class TownService {

    private TownRepository townRepository;

    public TownService() {
        this.townRepository = new TownRepository();
    }

    public ArrayList<Town> getAll() {
        return townRepository.get();
    }
}
