package org.example.repository;

import org.example.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий представляет собой интерфейс, который предоставляет набор методов для взаимодействия с базой данных.
 * <p>
 * JpaRepository - это интерфейс Spring Data JPA, который предоставляет множество методов (Create, Read, Update, Delete)
 * для работы с сущностями JPA без необходимости написания какого-либо кода реализации.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
