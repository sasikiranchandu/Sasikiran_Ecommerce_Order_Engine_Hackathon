package com.ecommerce.service;

import com.ecommerce.repository.CartRepository;

import java.util.Map;

public class CartService {

    private CartRepository repo = new CartRepository();

    public void addToCart(String userId, String productId, int qty) {
        repo.getCart(userId).merge(productId, qty, Integer::sum);
        System.out.println(" Added to cart");
    }

    public Map<String, Integer> getCart(String userId) {
        return repo.getCart(userId);
    }

    public void clearCart(String userId) {
        repo.clearCart(userId);
    }
    public void removeFromCart(String userId, String productId) {
        Map<String, Integer> cart = repo.getCart(userId);

        if (!cart.containsKey(productId)) {
            System.out.println("Product not in cart");
            return;
        }

        cart.remove(productId);
        System.out.println("Removed from cart");
    }
}