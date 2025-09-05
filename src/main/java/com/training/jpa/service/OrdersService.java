package com.training.jpa.service;

import com.training.jpa.entity.OrderItem;
import com.training.jpa.entity.Orders;
import com.training.jpa.model.dto.OrdersDTO;
import com.training.jpa.model.request.OrdersRequest;
import com.training.jpa.repository.OrdersItemRepository;
import com.training.jpa.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersItemRepository ordersItemRepository;

    @Transactional
    public OrdersDTO createOrder(OrdersRequest request){

        double total = 0.0;
        for (OrdersRequest.OrderLineRequest line : request.lines()) {
            total += line.total();
        }

        Orders ordersCreated = ordersRepository.save(Orders.builder()
                .customerId(request.customerId())
                .totalAmount(total)
                .status(request.status())
                .build()
        );

        List<OrderItem> lines = request.lines().stream().map(line -> {
            return OrderItem.builder()
                    .orderId(ordersCreated.getOrderId())
                    .orderItemId(line.itemId())
                    .quantity(line.qty())
                    .price(line.price())
                    .build();
        }).toList();

        ordersItemRepository.saveAll(lines);


        return new OrdersDTO(ordersCreated);
    }

    @Transactional(readOnly = true)
    public List<OrdersDTO> OrdersList(){
        return ordersRepository.findAll().stream().map(OrdersDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public OrdersDTO getById(Integer ordersId){
        return ordersRepository.findById(ordersId).map(OrdersDTO::new).orElseThrow(() -> new RuntimeException("Order not found!"));
    }

    @Transactional
    public OrdersDTO updateOrder(Integer ordersId, OrdersRequest request){
        Orders orders = ordersRepository.findById(ordersId).orElseThrow(() -> new RuntimeException("Order not found!"));
        orders.setCustomerId(request.customerId());
//        orders.setTotalAmount(request.);
        orders.setStatus(request.status());

        return new OrdersDTO(ordersRepository.save(orders));
    }

    @Transactional
    public void deleteOrder(Integer ordersId){
        ordersRepository.findById(ordersId).orElseThrow(() -> new RuntimeException("Order not found!"));
        ordersRepository.deleteById(ordersId);
    }


}
