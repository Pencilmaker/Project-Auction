package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class homeController {

	@GetMapping("product")
	public String ProductForm() {
		log.info("");
		return "product/product";
	}
}
