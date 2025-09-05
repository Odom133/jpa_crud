package com.training.jpa.model.dto;


import com.training.jpa.entity.Orders;
import com.training.jpa.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrdersDTO {
    private Integer orderId;
    private Integer customerId;
    private Double totalAmount;
    private OrderStatus status;

    public OrdersDTO(Orders orders) {
        this.orderId = orders.getOrderId();
        this.customerId = orders.getCustomerId();
        this.totalAmount = orders.getTotalAmount();
        this.status = orders.getStatus();
    }

}
