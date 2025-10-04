package com.company.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InventoryManager {

    private final List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.products.add(new Product("Advanced Laptop", 1200.50));
        this.products.add(new Product( "Wireless Mouse", 25.00));
    }

    public void addProduct(String name, double price) {

        Product product = new Product(name, price);

        this.products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
}