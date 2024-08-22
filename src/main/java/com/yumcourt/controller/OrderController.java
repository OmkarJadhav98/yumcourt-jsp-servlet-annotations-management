package com.yumcourt.controller;

import com.yumcourt.model.Order;
import com.yumcourt.model.Customer;
import com.yumcourt.model.Menu;
import com.yumcourt.model.DeliveryExecutive;
import com.yumcourt.service.OrderService;
import com.yumcourt.service.CustomerService;
import com.yumcourt.service.MenuService;
import com.yumcourt.service.DeliveryExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private DeliveryExecutiveService deliveryExecutiveService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.retrieveOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable long id) {
        Order order = orderService.findOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestParam long customerId,
                                            @RequestParam long menuId,
                                            @RequestParam long deliveryExecutiveId,
                                            @RequestParam String timestamp) {
        try {
            Customer customer = customerService.findCustomerById(customerId);
            Menu menu = menuService.findMenuById(menuId);
            DeliveryExecutive deliveryExecutive = deliveryExecutiveService.findDeliveryExecutiveById(deliveryExecutiveId);

            if (customer == null || menu == null || deliveryExecutive == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            LocalDateTime localDateTime = LocalDateTime.parse(timestamp);
            Order order = new Order(0, customer, menu, deliveryExecutive, localDateTime);
            orderService.createOrder(order);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable long id,
                                            @RequestParam long customerId,
                                            @RequestParam long menuId,
                                            @RequestParam long deliveryExecutiveId,
                                            @RequestParam String timestamp) {
        try {
            Customer customer = customerService.findCustomerById(customerId);
            Menu menu = menuService.findMenuById(menuId);
            DeliveryExecutive deliveryExecutive = deliveryExecutiveService.findDeliveryExecutiveById(deliveryExecutiveId);

            if (customer == null || menu == null || deliveryExecutive == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            LocalDateTime localDateTime = LocalDateTime.parse(timestamp);
            Order order = new Order(id, customer, menu, deliveryExecutive, localDateTime);
            orderService.updateOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
