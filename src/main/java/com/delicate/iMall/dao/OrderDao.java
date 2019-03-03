package com.delicate.iMall.dao;

import com.delicate.iMall.bean.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    List<Order> getOrdersByUserId(String userId);

    void addOrder(Order order);

    void deleteOrder(String orderId);

    void updateOrderInfo(Order order);
}
