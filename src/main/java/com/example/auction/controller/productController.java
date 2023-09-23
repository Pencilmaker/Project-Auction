package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class productController {

	@GetMapping("product")
	public String ProductForm() {
		log.info("");
		return "product/product";
	}
	
	@GetMapping("beforeprice")
	public String BeforePrice() {
		log.info("");
		return "product/beforeprice";
	}
}
