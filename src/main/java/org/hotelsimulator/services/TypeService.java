package org.hotelsimulator.services;

import org.hotelsimulator.models.Type;
import org.hotelsimulator.repository.TypeRepository;

import java.util.ArrayList;

public class TypeService {

    private TypeRepository typeRepository;

    public TypeService() {
        this.typeRepository = new TypeRepository();
    }

    public ArrayList<Type> getAll() {
        return typeRepository.get();
    }
}
