package ru.lanittercom.santa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanittercom.santa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order , Long> {
}
