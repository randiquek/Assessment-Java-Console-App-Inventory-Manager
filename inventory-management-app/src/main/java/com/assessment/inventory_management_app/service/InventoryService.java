package com.assessment.inventory_management_app.service;

import com.assessment.inventory_management_app.data.InventoryRepository;
import com.assessment.inventory_management_app.model.Product;
import com.assessment.inventory_management_app.ui.ConsoleIO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    ConsoleIO console = new ConsoleIO();

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


    public void addProduct() {

        int newProductId = console.getInteger("Enter Product ID: ");
        String newProductName = console.getString("Enter Product Name: ");
        int newQuantity = console.getInteger("Enter Quantity: ");
        double newPrice = console.getDouble("Enter Price: ");

        Product product = new Product();
        product.setProductId(newProductId);
        product.setProductName(newProductName);
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        inventoryRepository.save(product);

        System.out.println("Product added successfully!");

    }

    public void displayAllProducts() {
        List<Product> products = inventoryRepository.findAll();

        if(products.isEmpty()) {
            System.out.println("No products available to display");
        }
        else {
            for(Product product : products) {
                product.displayProductInfo();
            }
        }
    }

    public void searchProduct() {
        List<Product> products = inventoryRepository.findAll();

        String searchedProduct = console.getString("Enter Product ID or name");
        boolean productFound = false;

        try {

            // Searching by ID
            int searchedId = Integer.parseInt(searchedProduct);
            for(Product product : products) {
                if (searchedId == product.getProductId()) {
                    System.out.println("Product found:");
                    product.displayProductInfo();
                    productFound = true;
                    break;
                }
            }
        } catch (NumberFormatException e) {
            for (Product product : products) {
                // Searching by name
                if (searchedProduct.equalsIgnoreCase(product.getProductName())) {
                    System.out.println("Product found:");
                    product.displayProductInfo();
                    productFound = true;
                    break;
                }
            }
        }
        // If product wasn't found, print the following message
        if(!productFound) {
            System.out.println("Product not found or invalid entry");
        }
    }

    public void updateProduct() {

        int searchedProduct = console.getInteger("Enter a Product ID: ");
        Optional<Product> product = inventoryRepository.findById(searchedProduct);

        if(product.isPresent()) {
            System.out.println("Current Details: ");
            product.get().displayProductInfo();
            System.out.println("-----------------");
            String quantityEntered = console.getString("Enter New Quantity (or press Enter to skip)");
                if (!quantityEntered.trim().isEmpty()) {
                    try {
                        int newQuantity = Integer.parseInt(quantityEntered);
                        product.get().setQuantity(newQuantity);
                    } catch (NumberFormatException e) {
                        //Will skip if enter is pressed
                    }
                }

            String priceEntered = console.getString("Enter New Price (or press Enter to skip)");
                if (!priceEntered.trim().isEmpty()) {
                    try {
                        double newPrice = Double.parseDouble(priceEntered);
                        product.get().setPrice(newPrice);
                    } catch (NumberFormatException e) {
                        //Will skip if enter is pressed
                    }
                }
                inventoryRepository.save(product.get());
                System.out.println("Product updated successfully!");
        }
        else {
            System.out.println("Product not found or invalid entry");
        }
    }

    public void deleteProduct() {
        int searchedProduct = console.getInteger("Enter a Product ID: ");
        Optional<Product> product = inventoryRepository.findById(searchedProduct);

        if(product.isPresent()) {
            String response = console.getString("Are you sure you want to delete this product? (Y/N)");
                if(response.equalsIgnoreCase("Y")) {
                    inventoryRepository.deleteById(searchedProduct);
                    System.out.println("Product deleted successfully!");
                }
                else {
                    System.out.println("Product will not be deleted");
                }
        }
        else {
            System.out.println("Product not found. Please try again.");
        }
    }

}
