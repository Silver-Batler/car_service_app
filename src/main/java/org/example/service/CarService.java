package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CarDTO;
import org.example.entity.Car;
import org.example.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service для выполнения CRUD операций.
 */
@Service
@AllArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    /**
     * CREATE
     * <p>
     * Создает новый объект Car на основе предоставленного CarDTO и сохраняет его в репозиторий автомобилей.
     *
     * @param  dto  объект CarDTO, содержащий марку, модель и регистрационный номер автомобиля
     * @return      созданный объект класса «Автомобиль»
     */
    public Car create(CarDTO dto) {
        return carRepository.save(Car.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .registrationNumber(dto.getRegistrationNumber())
                .build());
    }

    /**
     * READ
     * <p>
     * Считывает все автомобили из хранилища автомобилей.
     *
     * @return список объектов Car, представляющих все автомобили в репозитории.
     */
    public List<Car> readAll(){
        return carRepository.findAll();
    }

    /**
     * UPDATE
     * <p>
     * Обновляет машину в репозитории.
     *
     * @param  car  объект класса «Автомобиль», который необходимо обновить
     * @return      обновленный объект класса «Автомобиль»
     */
    public Car update(Car car) {
        return carRepository.save(car);
    }

    /**
     * DELETE
     * <p>
     * Удаляет автомобиль с указанным идентификатором.
     *
     * @param  id  ID автомобиля, который нужно удалить
     */
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Car readById(Long id) {
        return carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Car not found - " + id));
    }
}
