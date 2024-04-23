package org.example.repository;

import org.example.entity.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
}
