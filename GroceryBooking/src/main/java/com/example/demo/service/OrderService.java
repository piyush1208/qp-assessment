package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Grocery;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.GroceryRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private GroceryRepository groceryRepository;

	public Order createOrder(Order order) {
		for (OrderItem item : order.getItems()) {
			Grocery grocery = groceryRepository.findById(item.getGroceryId()).orElseThrow();
			if (grocery.getStock() < item.getQuantity()) {
				throw new RuntimeException("Not enough stock");
			}
			grocery.setStock(grocery.getStock() - item.getQuantity());
			item.setPrice(grocery.getPrice() * item.getQuantity());
		}
		return orderRepository.save(order);
	}
}