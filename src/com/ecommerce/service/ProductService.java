package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

public class ProductService {

    private ProductRepository repo = new ProductRepository();

    public void addProduct(String id, String name, double price, int stock) {
        if (repo.findById(id) != null) {
            System.out.println("Product already exists");
            return;
        }
        repo.save(new Product(id, name, price, stock));
        System.out.println("✅ Product added");
    }

    public void viewProducts() {
        repo.findAll().forEach(p ->
                System.out.println(p.getId() + " | " + p.getName() + " | ₹" + p.getPrice() + " | " + p.getStock()));
    }

    public Product getProduct(String id) {
        return repo.findById(id);
    }
    public void updateStock(String id, int stock) {
        Product p = repo.findById(id);

        if (p == null) {
            System.out.println(" Product not found");
            return;
        }

        p.setStock(stock);
        System.out.println(" Stock updated");
    }

    public void lowStockAlert() {
        repo.findAll().stream()
            .filter(p -> p.getStock() <= 5)
            .forEach(p -> System.out.println(
                " LOW STOCK: " + p.getName() + " → " + p.getStock()
            ));
    }
}