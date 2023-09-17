package com.example.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/main")
	public String main(Model model) {
		
		return "index";
	}
	
	@GetMapping("/search")
	public String serach(Model model) {
		
		return "";
	}

	@GetMapping("/category")
	public String category(Model model) {
		
		return "";
	}
	
	@GetMapping("/mypage")
	public String MyPage(Model model) {
		
		return "";
	}
}
