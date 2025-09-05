package com.training.jpa.model.request;

public record OrdersItemRequest(
        Integer ordersId,
        Integer productId,
        Integer quantity,
        Double price
) {
}
