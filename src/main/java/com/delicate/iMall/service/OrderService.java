package com.delicate.iMall.service;

import com.delicate.iMall.bean.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersByUserId(String userId);

    void addOrder(Order order);

    void deleteOrder(String orderId);

    void updateOrderInfo(Order order);
}
