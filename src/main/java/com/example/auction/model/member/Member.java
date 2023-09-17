package com.example.auction.model.member;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	private String member_id;
	private String password;
	private String username;
	private DateTimeFormat birth;
	private String address1;
	private String address2;
	private String address3;
	private String email;
	private String phone;
}
