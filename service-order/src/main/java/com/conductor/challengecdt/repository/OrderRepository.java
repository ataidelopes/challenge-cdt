package com.conductor.challengecdt.repository;

import com.conductor.challengecdt.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
