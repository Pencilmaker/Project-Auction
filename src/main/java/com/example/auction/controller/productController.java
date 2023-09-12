package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class productController {

	@GetMapping("{product_id}")
	public String ProductForm() {
		log.info("ProductForm.html");
		return "product/productForm";
	}
	
}
