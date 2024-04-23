package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  // Множество заказов у машины, но одна машина у заказа
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne  // Множество заказов у сотрудника, но один сотрудник у заказа
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne  // Множество заказов у клиента, но один клиент у заказа
    @JoinColumn(name = "client_id")
    private Client client;

    private String status;  // Статус заказа (принят, в процессе, завершен)
    private String orderDate;

}
