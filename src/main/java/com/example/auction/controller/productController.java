package com.example.auction.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.auction.model.product.Buy_log;
import com.example.auction.model.product.Product;
import com.example.auction.repository.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class productController {
	
	private final ProductMapper productMapper;

	@GetMapping("product")
	public String productForm(
			@RequestParam(required = true) Long product_id,
			Model model) {
		
		Product product = productMapper.findProduct(product_id);
		// html에 정보 주입
		log.info("product의 값 : {}", product);
		model.addAttribute("product", product);
		// 경매 시스템
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
		
		if (beforePrice != null) {
		
		log.info("가격: {}", beforePrice);
		
		model.addAttribute("buy_logs", beforePrice);
		
		}
		
		return "product/beforeprice";
	}
	
	@GetMapping("regist")
		public String registForm() {
		log.info("제품 등록 창");
		return "product/regist";
	}
}
