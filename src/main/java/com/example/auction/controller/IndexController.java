package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String main(Model model) {
		
		return "index";
	}
	
	@GetMapping("/search/{search}")
	public String serach(@PathVariable String Search, Model model) {
		
		return "search";
	}

	@GetMapping("/category")
	public String category(Model model) {
		
		return "category";
	}
	
	@GetMapping("/mypage")
	public String MyPage(Model model) {
		
		return "mypage";
	}
}
