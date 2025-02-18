package com.assessment.inventory_management_app.ui;

public enum MenuOptions {

    ADD("Add Product"),
    VIEW_ALL("View Products"),
    SEARCH("Search Product"),
    UPDATE("Update Product"),
    DELETE("Delete Product"),
    EXIT("Exit");

    private String message;

    MenuOptions(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
