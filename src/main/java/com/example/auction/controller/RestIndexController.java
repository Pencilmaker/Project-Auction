package com.example.auction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auction.model.product.Product;
import com.example.auction.repository.IndexRepository;

@RestController
public class RestIndexController {
	private static IndexRepository indexRepository;
	
	@GetMapping("/listProduct")
	public List<Product> getListProduct(){
		return List<>;
	}
}