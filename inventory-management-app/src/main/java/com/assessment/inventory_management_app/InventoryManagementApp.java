package com.assessment.inventory_management_app;

import com.assessment.inventory_management_app.data.InventoryRepository;
import com.assessment.inventory_management_app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementApp implements CommandLineRunner {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private Product product;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApp.class, args);
	}


	public void run(String[] args) {



	}
}
