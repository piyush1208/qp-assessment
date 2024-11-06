package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grocery;
import com.example.demo.service.GroceryService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	@Autowired
	private GroceryService groceryService;

	@PostMapping("/groceries")
	public Grocery addGrocery(@RequestBody Grocery grocery) {
		return groceryService.addGrocery(grocery);
	}

	@GetMapping("/groceries")
	public List<Grocery> getAllGroceries() {
		return groceryService.getAllGroceries();
	}

	@PutMapping("/groceries/{id}")
	public Grocery updateGrocery(@PathVariable Long id, @RequestBody Grocery grocery) {
		return groceryService.updateGrocery(id, grocery);
	}

	@DeleteMapping("/groceries/{id}")
	public void deleteGrocery(@PathVariable Long id) {
		groceryService.deleteGrocery(id);
	}
}