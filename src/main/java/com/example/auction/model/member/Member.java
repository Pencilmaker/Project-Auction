package com.example.auction.model.member;

import lombok.Data;

@Data
public class Member {
	private String member_id;
	private String password;
	private String username;
	private String birth;
	private String gender;
	private String address_1;
	private String address_2;
	private String address_3;
	private String email;
	private String phone;
}
