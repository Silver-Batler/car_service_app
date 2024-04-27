package org.example.repository;

import org.example.entity.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    List<CarOrder> findByStatus(String status);
    List<CarOrder> findByCarId(Long Id);
    List<CarOrder> findByEmployeeId(Long Id);
    List<CarOrder> findByClientId(Long Id);
}
