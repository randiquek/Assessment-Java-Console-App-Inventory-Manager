package com.assessment.inventory_management_app.model;

import com.assessment.inventory_management_app.data.InventoryRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PRODUCT")
public class Product {

    @Id
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product() {
    }

    public Product(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Methods
    public void displayProductInfo() {
        String productInfo = "Product ID: " + productId + " | Product Name: " + productName + " | Product Quantity: " + quantity + " | Product Price: $" + price;
        System.out.println(productInfo);
    }
}
