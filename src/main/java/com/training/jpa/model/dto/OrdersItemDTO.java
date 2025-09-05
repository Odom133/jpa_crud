package com.training.jpa.model.dto;


import com.training.jpa.entity.OrderItem;
import com.training.jpa.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrdersItemDTO {
    private Integer ordersItemId;
    private Integer ordersId;
    private Product productId;
    private Integer quantity;
    private Double price;

    public OrdersItemDTO(OrderItem ordersItem) {
        this.ordersItemId = ordersItem.getOrderItemId();
        this.ordersId = ordersItem.getOrderId();
        this.productId = ordersItem.getProductId();
        this.quantity = ordersItem.getQuantity();
        this.price = ordersItem.getPrice();
    }
}
