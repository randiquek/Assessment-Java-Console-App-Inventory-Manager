package com.assessment.inventory_management_app.data;

import com.assessment.inventory_management_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Product, Integer> {

}
