package com.example.auction.model.product;

import lombok.Data;

@Data
public class Product {
	private Long product_id;
	private String product_name;
	private String resisted_time;
	private String explanation;
}
