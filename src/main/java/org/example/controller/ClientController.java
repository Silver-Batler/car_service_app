package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ClientDTO;
import org.example.entity.Client;
import org.example.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto) {
        return new ResponseEntity<>(clientService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
            clientService.delete(id);
        }
        catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}