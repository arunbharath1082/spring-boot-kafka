package com.arun.OrderService.controller;

import com.arun.BaseDomains.dto.Order;
import com.arun.BaseDomains.dto.OrderEvent;
import com.arun.OrderService.kafka.OrderProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order){

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setMessage("Order Placed");
        orderEvent.setStatus("SUCCESS");
        orderEvent.setOrder(order);
        orderProducer.sendMessages(orderEvent);

        return "Order Placed";
    }
}
