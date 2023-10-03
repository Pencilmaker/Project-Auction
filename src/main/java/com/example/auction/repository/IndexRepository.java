package com.example.auction.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.auction.model.member.Member;
import com.example.auction.model.product.Product;

@Mapper
public interface IndexRepository {
	public List<Product> ListProduct();
}
