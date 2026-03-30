package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private String id;
    private String userId;
    private Map<String, Integer> items;
    private double total;
    private String status;
    private LocalDateTime createdAt;

    public Order(String id, String userId, Map<String, Integer> items, double total) {
        this.id = id;
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.status = "CREATED";
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

