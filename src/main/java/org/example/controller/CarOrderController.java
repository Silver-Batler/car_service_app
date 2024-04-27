package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CarOrderDTO;
import org.example.entity.CarOrder;
import org.example.service.CarOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car_orders")
@AllArgsConstructor
public class CarOrderController {
    private final CarOrderService carOrderService;

    @PostMapping
    public ResponseEntity<CarOrder> create(@RequestBody CarOrderDTO dto) {
        return new ResponseEntity<>(carOrderService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarOrder>> readAll() {
        return new ResponseEntity<>(carOrderService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarOrder> update(@RequestBody CarOrder carOrder) {
        return new ResponseEntity<>(carOrderService.update(carOrder), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
        carOrderService.delete(id);
        }
        catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CarOrder>> readByStatus(@PathVariable String status) {
        return new ResponseEntity<>(carOrderService.readByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<CarOrder>> readByCarId(@PathVariable Long carId) {
        return new ResponseEntity<>(carOrderService.readByCarId(carId), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<CarOrder>> readByEmployeeId(@PathVariable Long employeeId) {
        return new ResponseEntity<>(carOrderService.readByEmployeeId(employeeId), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<CarOrder>> readByClientId(@PathVariable Long clientId) {
        return new ResponseEntity<>(carOrderService.readByClientId(clientId), HttpStatus.OK);
    }
}
