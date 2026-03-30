package com.ecommerce.repository;

import com.ecommerce.model.Product;
import java.util.*;

public class ProductRepository {

    private Map<String, Product> products = new HashMap<>();

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Product findById(String id) {
        return products.get(id);
    }

    public Collection<Product> findAll() {
        return products.values();
    }
}