package com.yumcourt.service;

import com.yumcourt.model.Order;
import com.yumcourt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> retrieveOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
