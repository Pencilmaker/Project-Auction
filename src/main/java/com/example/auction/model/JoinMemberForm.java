package com.example.auction.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class JoinMemberForm {
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
	
	public static Member toMember(JoinMemberForm joinMemberForm) {
		Member member = new Member();
		member.setMember_id(joinMemberForm.getMember_id());
		member.setPassword(joinMemberForm.getPassword());
		member.setUsername(joinMemberForm.getUsername());
		member.setBirth(joinMemberForm.getBirth());
		member.setGender(joinMemberForm.getGender());
		member.setAddress1(joinMemberForm.getAddress1());
		member.setAddress2(joinMemberForm.getAddress2());
		member.setAddress3(joinMemberForm.getAddress3());
		member.setEmail(joinMemberForm.getEmail());
		member.setPhone(joinMemberForm.getPhone());		
		return member;
	}
}
