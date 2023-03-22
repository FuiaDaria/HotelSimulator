package org.hotelsimulator.services;

import org.hotelsimulator.models.Client;
import org.hotelsimulator.repository.ClientRepository;

import java.util.ArrayList;

public class ClientService {

    private ClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public ArrayList<Client> getAll() {
        return clientRepository.get();
    }

    public void addClient(String name) {
        Client client = new Client();
        client.setClient_name(name);
        clientRepository.add(client);
    }

    public void deleteClient(int id) {
        Client client = new Client();
        client.setClient_id(id);
        clientRepository.delete(id);
    }

}
