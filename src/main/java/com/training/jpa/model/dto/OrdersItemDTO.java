package com.training.jpa.model.dto;


import com.training.jpa.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrdersItemDTO {
    private Integer order_item_id;
    private Integer ordersId;
    private Integer productId;
    private Integer quantity;
    private Double price;

    public OrdersItemDTO(OrderItem ordersItem) {
        this.order_item_id = ordersItem.getOrder_item_id();
        this.ordersId = ordersItem.getOrderId();
        this.productId = ordersItem.getProductId();
        this.quantity = ordersItem.getQuantity();
        this.price = ordersItem.getPrice();
    }
}
