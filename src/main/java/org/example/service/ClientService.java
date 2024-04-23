package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.ClientDTO;
import org.example.entity.Client;
import org.example.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientDTO dto) {
        return clientRepository.save(Client.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .build());
    }

    public List<Client> readAll(){
        return clientRepository.findAll();
    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Client readById(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Client not found - " + id));
    }
}
