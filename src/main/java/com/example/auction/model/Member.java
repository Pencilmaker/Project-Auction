package com.example.auction.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Member {
	private String member_id;
	private String password;
	private String username;
	private LocalDate birth;
	private GenderType gender;
	private String address1;
	private String address2;
	private String address3;
	private String email;
	private String phone;
}
