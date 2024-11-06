package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grocery;
import com.example.demo.model.Order;
import com.example.demo.service.GroceryService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private GroceryService groceryService;
	@Autowired
	private OrderService orderService;

	@GetMapping("/groceries")
	public List<Grocery> getAvailableGroceries() {
		return groceryService.getAllGroceries();
	}

	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
}
