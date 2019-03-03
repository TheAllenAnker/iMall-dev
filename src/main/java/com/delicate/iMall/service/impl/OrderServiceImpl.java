package com.delicate.iMall.service.impl;

import com.delicate.iMall.bean.Order;
import com.delicate.iMall.dao.OrderDao;
import com.delicate.iMall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderDao.getOrdersByUserId(userId);
    }

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void deleteOrder(String orderId) {
        orderDao.deleteOrder(orderId);
    }

    @Override
    public void updateOrderInfo(Order order) {
        orderDao.updateOrderInfo(order);
    }
}
