package org.example.dto;

import lombok.Data;

/**
 * Объект DTO (Data Transfer Object) представляет собой удобный способ организации
 * взаимодействия между клиентом и сервером, так как он позволяет отправлять только необходимые данные.
 */
@Data
public class CarDTO {
    private String brand;
    private String model;
    private String registrationNumber;
}
