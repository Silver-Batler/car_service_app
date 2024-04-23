package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Сущность
@Data // Генерирует геттеры и сеттеры
@Builder // Паттерн проектирования Builder
@NoArgsConstructor // Генерирует конструктор без аргументов
@AllArgsConstructor // Генерирует конструктор с аргументами
public class Car {

    @Id // Первичный ключ
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Автоинкремент
    private Long id;

    private String brand;
    private String model;
    private String registrationNumber;

}