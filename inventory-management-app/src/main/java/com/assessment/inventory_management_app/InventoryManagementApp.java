package com.assessment.inventory_management_app;

import com.assessment.inventory_management_app.data.InventoryRepository;
import com.assessment.inventory_management_app.model.Product;
import com.assessment.inventory_management_app.ui.ConsoleIO;
import com.assessment.inventory_management_app.ui.MenuOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InventoryManagementApp implements CommandLineRunner {

	@Autowired
	private InventoryRepository inventoryRepository;

	private boolean isRunning = false;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApp.class, args);
	}


	public void run(String[] args) {

		isRunning = true;
		ConsoleIO console = new ConsoleIO();
		MenuOptions option;

		while(isRunning) {
			option = console.displayMainMenu();
			switch (option) {
				case ADD:
					// addProduct()
					break;
				case VIEW_ALL:
					// displayProduct()
					break;
				case SEARCH:
					// searchProduct()
					break;
				case UPDATE:
					// updateProduct()
					break;
				case DELETE:
					// deleteProduct()
					break;
				case EXIT:
					console.printHeader("Exiting application. Goodbye");
					isRunning = false;
					break;
			}







		}

	}
}
