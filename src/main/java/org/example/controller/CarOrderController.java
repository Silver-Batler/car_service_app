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
        carOrderService.delete(id);
        return HttpStatus.OK;
    }
}
