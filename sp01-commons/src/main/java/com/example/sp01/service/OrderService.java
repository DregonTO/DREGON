package com.example.sp01.service;

import com.example.sp01.pojo.Order;

public interface OrderService {
    Order getOrder(String orderId);
    void addOrder(Order order);
}
