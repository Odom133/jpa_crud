package com.training.jpa.controller;


import com.training.jpa.entity.Orders;
import com.training.jpa.model.dto.OrdersDTO;
import com.training.jpa.model.request.OrdersRequest;
import com.training.jpa.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    // create order

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OrdersDTO create(@RequestBody OrdersRequest request){
        return ordersService.createOrder(request);
    }

    // list All
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrdersDTO> list(){
        return ordersService.OrdersList();
    }

    // get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrdersDTO get(@PathVariable("id") Integer ordersId){
        return ordersService.getById(ordersId);
    }

    // delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer ordersId){
        ordersService.deleteOrder(ordersId);
    }

    // update
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrdersDTO update(@PathVariable("id") Integer ordersId, @RequestBody OrdersRequest request){
        return ordersService.updateOrder(ordersId, request);
    }

}
