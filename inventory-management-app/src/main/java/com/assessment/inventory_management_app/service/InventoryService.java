package com.assessment.inventory_management_app.service;

import com.assessment.inventory_management_app.data.InventoryRepository;
import com.assessment.inventory_management_app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    private void addStock(int productId, int amount) {
        Optional<Product> productNeeded = inventoryRepository.findById(productId);
        if (productNeeded.isPresent() && amount > 0) {
            Product product = productNeeded.get();
            product.setQuantity(product.getQuantity() + amount);
            inventoryRepository.save(product);
            System.out.println("Stock amount of " + amount + " was added. New quantity in stock is: " + product.getQuantity());
            }
        else {
            System.out.println("Invalid product ID or amount entered.");
        }

    }
    private void removeStock(int productId, int amount) {
        Optional<Product> productNeeded = inventoryRepository.findById(productId);
        if(productNeeded.isPresent()) {
            Product product = productNeeded.get();
            if(product.getQuantity() >= amount && amount > 0) {
                product.setQuantity(product.getQuantity() - amount);
                inventoryRepository.save(product);
                System.out.println("Stock amount of " + amount + " was removed. New quantity in stock is: " + product.getQuantity());
            }
            else {
                System.out.println("Stock amount isn't valid.");
            }
        }
        else {
            System.out.println("Product wasn't found");
        }
    }

    private void updatePrice(int productId, double newPrice) {
        Optional<Product> productNeeded = inventoryRepository.findById(productId);
        if(productNeeded.isPresent()) {
            Product product = productNeeded.get();
            product.setPrice(newPrice);
            inventoryRepository.save(product);
        }
        else {
            System.out.println("Invalid product ID or price entry.");
        }
    }

}
