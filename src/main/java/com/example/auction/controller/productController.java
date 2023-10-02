package com.example.auction.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.auction.model.product.Buy_log;
import com.example.auction.repository.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class productController {
	
	private final ProductMapper productMapper;

	@GetMapping("{product}")
	public String productForm(Model model) {
		log.info("상품정보");
		
		model.addAttribute("buy_log", new Buy_log());
		
		return "product/product";
	}
	
	@PostMapping("product")
	public String productInfo(@Validated @ModelAttribute("buy_log") Buy_log buy_log) {
		log.info("입력 값:{}", buy_log);
		return "product/product";
	}
	
	@GetMapping("beforeprice")
	public String beforePrice(Model model) {
		List<Buy_log> beforePrice = productMapper.findBuy_log(1L);
		
		model.addAttribute("buy_logs", beforePrice);
		
		return "product/beforeprice";
	}
	
	@GetMapping("regist")
		public String registForm() {
		log.info("제품 등록 창");
		return "product/regist";
	}
}
