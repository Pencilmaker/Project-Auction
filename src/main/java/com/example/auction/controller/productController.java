package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("product")
public class productController {
	
	@GetMapping("info")
	public String productForm() {
		log.info("productForm");
		return "product/productForm";
	}
}
