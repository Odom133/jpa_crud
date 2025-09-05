package com.training.jpa.service;


import com.training.jpa.entity.OrderItem;
import com.training.jpa.entity.Orders;
import com.training.jpa.entity.Product;
import com.training.jpa.model.dto.OrdersItemDTO;
import com.training.jpa.model.request.OrdersRequest;
import com.training.jpa.repository.OrdersItemRepository;
import com.training.jpa.repository.OrdersRepository;
import com.training.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrdersItemService {

    private final OrdersItemRepository ordersItemRepository;
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrdersItemDTO createOrders(OrdersRequest request){

        Orders orders = ordersRepository.findById(request)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        OrderItem orderItemCreated = ordersItemRepository.save(OrderItem.builder()
                .orderItemId(request));
    }


}
