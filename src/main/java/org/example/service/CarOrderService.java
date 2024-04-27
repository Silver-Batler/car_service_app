package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.CarOrderDTO;
import org.example.entity.CarOrder;
import org.example.repository.CarOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarOrderService {
    private final CarOrderRepository carOrderRepository;
    private final CarService carService;
    private final EmployeeService employeeService;
    private final ClientService clientService;

    public CarOrder create(CarOrderDTO dto) {
        return carOrderRepository.save(CarOrder.builder()
                .car(carService.readById(dto.getCarId()))
                .employee(employeeService.readById(dto.getEmployeeId()))
                .client(clientService.readById(dto.getClientId()))
                .status(dto.getStatus())
                .orderDate(dto.getOrderDate())
                .build());
    }

    public List<CarOrder> readAll(){
        return carOrderRepository.findAll();
    }

    public CarOrder update(CarOrder carOrder) {
        return carOrderRepository.save(carOrder);
    }

    public void delete(Long id) {
        carOrderRepository.deleteById(id);
    }

    public List<CarOrder> readByStatus(String status) {
        return carOrderRepository.findByStatus(status);
    }

    public List<CarOrder> readByCarId(Long Id) {
        return carOrderRepository.findByCarId(Id);
    }

    public List<CarOrder> readByEmployeeId(Long Id) {
        return carOrderRepository.findByEmployeeId(Id);
    }

    public List<CarOrder> readByClientId(Long Id) {
        return carOrderRepository.findByClientId(Id);
    }
}

