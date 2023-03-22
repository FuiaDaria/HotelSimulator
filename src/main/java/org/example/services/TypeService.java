package org.example.services;

import org.example.models.Type;
import org.example.repository.TypeRepository;

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
