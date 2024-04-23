package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee create(EmployeeDTO dto) {
        return employeeRepository.save(Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .position(dto.getPosition())
                .phoneNumber(dto.getPhoneNumber())
                .build());
    }

    public List<Employee> readAll(){
        return employeeRepository.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee readById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found - " + id));
    }
}
