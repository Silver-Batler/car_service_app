package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CarDTO;
import org.example.entity.Car;
import org.example.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Контроллер используется для обработки HTTP-запросов.
 */
@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    // Сервис, который этот контроллер использует для выполнения операций
    private final CarService carService;

    /**
     * Обрабатывает POST-запрос для создания нового автомобиля.
     * @param dto Объект передачи данных автомобиля.
     * @return Объект ResponseEntity, содержащий созданный автомобиль и статус HTTP.
     */
    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CarDTO dto) {
        return new ResponseEntity<>(carService.create(dto), HttpStatus.CREATED);
    }
    /**
     * Обрабатывает GET-запрос для получения всех автомобилей.
     * @return Объект ResponseEntity, содержащий список всех автомобилей и статус HTTP.
     */
    @GetMapping
    public ResponseEntity<List<Car>> readAll() {
        return new ResponseEntity<>(carService.readAll(), HttpStatus.OK);
    }

    /**
     * Обрабатывает PUT-запрос для обновления существующего автомобиля.
     * @param car Объект автомобиля, который необходимо обновить.
     * @return Объект ResponseEntity, содержащий обновленный автомобиль и статус HTTP.
     */
    @PutMapping
    public ResponseEntity<Car> update(@RequestBody Car car) {
        return new ResponseEntity<>(carService.update(car), HttpStatus.OK);
    }

    /**
     * Обрабатывает DELETE-запрос для удаления автомобиля по идентификатору.
     * @param id Идентификатор того автомобиля, который необходимо удалить.
     * @return HTTP-статус.
     */
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        try {
            carService.delete(id);
        } catch (Exception e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}
