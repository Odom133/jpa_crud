package com.training.jpa.repository;

import com.training.jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersItemRepository extends JpaRepository<OrderItem, Integer> {

    List<OrderItem> findAllByOrderId(Integer id);

}
