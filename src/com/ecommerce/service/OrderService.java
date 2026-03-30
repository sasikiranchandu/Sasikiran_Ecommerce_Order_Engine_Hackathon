package com.ecommerce.service;

import java.util.HashMap;
import java.util.Map;

import com.ecommerce.model.Order;
import com.ecommerce.util.IdGenerator;

public class OrderService {

    private Map<String, Order> orders = new HashMap<>();

    public void placeOrder(String userId, Map<String, Integer> cart) {

        if (cart.isEmpty()) {
            System.out.println(" Cart is empty");
            return;
        }

        String orderId = IdGenerator.generate("ORD");
        Order order = new Order(orderId, userId, cart, 0);

        order.setStatus("PAID");
        orders.put(orderId, order);

        System.out.println(" Order placed: " + orderId);
    }

    public void viewOrders() {
        orders.values().forEach(o ->
                System.out.println(o.getId() + " | " + o.getStatus()));
    }
    public void cancelOrder(String orderId) {
        Order o = orders.get(orderId);

        if (o == null) {
            System.out.println(" Order not found");
            return;
        }

        o.setStatus("CANCELLED");
        System.out.println(" Order cancelled");
    }

    public void returnProduct(String orderId) {
        Order o = orders.get(orderId);

        if (o == null) {
            System.out.println("Order not found");
            return;
        }

        o.setStatus("RETURNED");
        System.out.println(" Product returned");
    }

    public void advanceState(String orderId) {
        Order o = orders.get(orderId);

        if (o == null) {
            System.out.println(" Order not found");
            return;
        }

        if (o.getStatus().equals("PAID")) {
            o.setStatus("SHIPPED");
        } else if (o.getStatus().equals("SHIPPED")) {
            o.setStatus("DELIVERED");
        } else {
            System.out.println(" Cannot advance state");
            return;
        }

        System.out.println("Status updated to " + o.getStatus());
    }
}