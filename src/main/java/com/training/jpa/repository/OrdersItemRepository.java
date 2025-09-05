package com.training.jpa.repository;

import com.training.jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersItemRepository extends JpaRepository<OrderItem, Integer> {
}
