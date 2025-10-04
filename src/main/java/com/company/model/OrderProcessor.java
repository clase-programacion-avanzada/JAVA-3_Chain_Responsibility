package com.company.model;


public class OrderProcessor {

    private final InventoryManager inventory;

    public OrderProcessor(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public void processNewProduct(String name, double price) {
        // 1. It delegates the responsibility of saving it to the inventory manager.
        // The interaction is still a single method call! We don't "talk to strangers."
        this.inventory.addProduct(name, price);
    }
}