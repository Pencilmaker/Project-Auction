package com.example.auction.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.auction.model.product.Buy_log;
import com.example.auction.model.product.Product;

@Mapper
public interface ProductMapper {
	
	// 제품 찾기
	Product findProduct(Long product_id);
	
	// 가격 로그 찾기
	List<Buy_log> findBuy_log(Long product_id);
}
