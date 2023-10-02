package com.example.auction.model.product;

import lombok.Data;

@Data
public class Buy_log {
	private Long product_id;
	private Long update_price;
	private String buyer;
	private String update_time;
}
