package com.example.demo.controller;


import com.example.demo.model.order.Order;
import com.example.demo.respository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/{userId}")
    public Order createNewOrder(@PathVariable Long userId, @RequestBody Order orderBody){
        return orderService.createNewUser(userId, orderBody);
    }

    @GetMapping("/{userId}")
    public List<Order> getUserAllOrder(@PathVariable Long userId){
        return orderService.fetchUserOrder(userId);
    }
}
