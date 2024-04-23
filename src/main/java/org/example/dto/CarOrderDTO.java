package org.example.dto;

import lombok.Data;

@Data
public class CarOrderDTO {
    private Long carId;
    private Long employeeId;
    private Long clientId;
    private String status;
    private String orderDate;
}
