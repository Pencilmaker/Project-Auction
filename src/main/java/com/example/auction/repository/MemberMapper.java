package com.example.auction.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.auction.model.member.Member;

@Mapper
public interface MemberMapper {
	
	// 회원가입
	void saveMember(Member member);
	
	
	// 아이디 찾기
	Member findMember(String member_id);
}
