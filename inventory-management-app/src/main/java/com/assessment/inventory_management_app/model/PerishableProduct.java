package com.assessment.inventory_management_app.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("PERISHABLE")
public class PerishableProduct extends Product {

    @Temporal(TemporalType.DATE)
    private LocalDate expirationDate;

    public PerishableProduct(String productName, int quantity, double price, LocalDate expirationDate) {
        super(productName, quantity, price);
        this.expirationDate = expirationDate;
    }

    public PerishableProduct() {

    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void displayProductInfo() {
        String productInfo = "Product ID: " + getProductId() + " | Product Name: " + getProductName() + " | Product Quantity: " + getQuantity() + " | Product Price: $" + getPrice();

        if(expirationDate != null) {
            productInfo += " | Expiration Date: " + getExpirationDate();
        }

        System.out.println(productInfo);
    }
}
