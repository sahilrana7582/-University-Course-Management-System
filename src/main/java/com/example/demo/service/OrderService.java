package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.model.order.Order;
import com.example.demo.respository.OrderRepository;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRespository userRespository;

    public Order createNewUser(Long userId, Order orderBody){
        User user = userRespository.findById(userId)
                                .orElseThrow(()-> new RuntimeException("User Not Found!"));

        Order newOrder = new Order();
        newOrder.setProductName(orderBody.getProductName());
        newOrder.setPrice(orderBody.getPrice());
        newOrder.setUser(user);

        return orderRepository.save(newOrder);
    }

    public List<Order> fetchUserOrder(Long userId){
        User user = userRespository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found!"));


        return user.getOrders();
    }
}
