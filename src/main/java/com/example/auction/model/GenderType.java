package com.example.auction.model;

public enum GenderType {
	MALE("남성"),
	FEMALE("여성");
	
	private final String description;
	
	private GenderType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
