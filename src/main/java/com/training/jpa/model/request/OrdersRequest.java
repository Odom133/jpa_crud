package com.training.jpa.model.request;


import com.training.jpa.model.enums.OrderStatus;

import java.util.List;

public record OrdersRequest(

        Integer customerId,
        OrderStatus status,
        List<OrderLineRequest> lines
) {
    public record OrderLineRequest(
            Integer itemId,
            Integer qty,
            Double price
    ) {
        public Double total() {
            return price * qty;
        }
    }
}
