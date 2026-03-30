package com.ecommerce.controller;

import com.ecommerce.service.*;

import java.util.Scanner;

public class ECommerceController {

    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();
    private PaymentService paymentService = new PaymentService();

    private Scanner sc = new Scanner(System.in);

    public void start() {

    	while (true) {

    	    System.out.println("\n CLI Menu\n");

    	    System.out.println("1. Add Product");
    	    System.out.println("2. View Products");
    	    System.out.println("3. Add to Cart");
    	    System.out.println("4. Remove from Cart");
    	    System.out.println("5. View Cart");
    	    System.out.println("6. Apply Coupon");
    	    System.out.println("7. Place Order");
    	    System.out.println("8. Cancel Order");
    	    System.out.println("9. View Orders");
    	    System.out.println("10. Low Stock Alert");
    	    System.out.println("11. Return Product");
    	    System.out.println("12. Simulate Concurrent Users");
    	    System.out.println("13. View Logs");
    	    System.out.println("14. Trigger Failure Mode");
    	    System.out.println("0. Exit");

    	    System.out.print("\nEnter choice: ");
    	    String ch = sc.nextLine();

    	    switch (ch) {

    	    case "1" -> addProduct();

    	    case "2" -> productService.viewProducts();

    	    case "3" -> addToCart();

    	    case "4" -> removeFromCart();

    	    case "5" -> viewCart();

    	    case "6" -> applyCoupon();

    	    case "7" -> placeOrder();

    	    case "8" -> cancelOrder();

    	    case "9" -> orderService.viewOrders();

    	    case "10" -> lowStockAlert();

    	    case "11" -> returnProduct();

    	    case "12" -> simulateConcurrency();

    	    case "13" -> viewLogs();

    	    case "14" -> toggleFailureMode();

    	    case "0" -> {
    	        System.out.println("Bye");
    	        return;
    	    }

    	    default -> System.out.println(" Invalid choice");
    	}
        }
    }

    // ================= METHODS =================

    private void addProduct() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(sc.nextLine());

        productService.addProduct(id, name, price, stock);
    }

    private void updateStock() {
        System.out.print("Product ID: ");
        String id = sc.nextLine();
        System.out.print("New Stock: ");
        int stock = Integer.parseInt(sc.nextLine());

        productService.updateStock(id, stock);
    }

    private void addToCart() {
        System.out.print("User: ");
        String user = sc.nextLine();
        System.out.print("Product: ");
        String pid = sc.nextLine();
        System.out.print("Qty: ");
        int qty = Integer.parseInt(sc.nextLine());

        cartService.addToCart(user, pid, qty);
    }

    private void viewCart() {
        System.out.print("User: ");
        String user = sc.nextLine();
        System.out.println(cartService.getCart(user));
    }

    private void removeFromCart() {
        System.out.print("User: ");
        String user = sc.nextLine();
        System.out.print("Product ID: ");
        String pid = sc.nextLine();

        cartService.removeFromCart(user, pid);
    }

    private void applyCoupon() {
        System.out.println("Coupon applied (logic in service)");
    }

    private void placeOrder() {
        System.out.print("User: ");
        String user = sc.nextLine();

        orderService.placeOrder(user, cartService.getCart(user));
        cartService.clearCart(user);
    }

    private void cancelOrder() {
        System.out.print("Order ID: ");
        String oid = sc.nextLine();

        orderService.cancelOrder(oid);
    }

    private void returnProduct() {
        System.out.print("Order ID: ");
        String oid = sc.nextLine();

        orderService.returnProduct(oid);
    }

    private void simulateConcurrency() {
        System.out.println(" Concurrency simulation handled in service");
    }

    private void advanceOrderState() {
        System.out.print("Order ID: ");
        String oid = sc.nextLine();

        orderService.advanceState(oid);
    }

    private void lowStockAlert() {
        productService.lowStockAlert();
    }

    private void viewLogs() {
        System.out.println("Logs handled in LoggerUtil");
    }

    private void toggleFailureMode() {
        System.out.println("Failure mode toggled");
    }

    private void systemStatus() {
        System.out.println("System status view");
    }
}