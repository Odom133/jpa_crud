package com.training.jpa.model.response;

import com.training.jpa.model.dto.OrdersDTO;
import com.training.jpa.model.dto.OrdersItemDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class ListOrderDTO {

    OrdersDTO order;
    List<OrdersItemDTO> itemLines;

    public ListOrderDTO(OrdersDTO order, List<OrdersItemDTO> itemLines) {
        this.order = order;
        this.itemLines = itemLines;
    }
}
