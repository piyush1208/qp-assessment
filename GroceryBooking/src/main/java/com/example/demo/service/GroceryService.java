package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Grocery;
import com.example.demo.repository.GroceryRepository;

@Service
public class GroceryService {

	@Autowired
	private GroceryRepository groceryRepository;

	public Grocery addGrocery(Grocery grocery) {
		return groceryRepository.save(grocery);
	}

	public List<Grocery> getAllGroceries() {
		return groceryRepository.findAll();
	}

	public Grocery updateGrocery(Long id, Grocery updatedGrocery) {
		Grocery grocery = groceryRepository.findById(id).orElseThrow();
		grocery.setName(updatedGrocery.getName());
		grocery.setPrice(updatedGrocery.getPrice());
		grocery.setDescription(updatedGrocery.getDescription());
		grocery.setStock(updatedGrocery.getStock());
		return groceryRepository.save(grocery);
	}

	public void deleteGrocery(Long id) {
		groceryRepository.deleteById(id);
	}
}
