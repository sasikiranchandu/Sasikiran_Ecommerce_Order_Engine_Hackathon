package com.ecommerce.repository;

import java.util.*;

public class CartRepository {

    private Map<String, Map<String, Integer>> carts = new HashMap<>();

    public Map<String, Integer> getCart(String userId) {
        return carts.computeIfAbsent(userId, k -> new HashMap<>());
    }

    public void clearCart(String userId) {
        carts.put(userId, new HashMap<>());
    }
}