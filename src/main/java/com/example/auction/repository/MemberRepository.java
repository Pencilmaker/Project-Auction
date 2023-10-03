package com.example.auction.repository;

import com.example.auction.model.Member;

public interface MemberRepository {
	// 회원 가입
	void saveMember(Member member);
	
	// 아이디로 회원정보 검색
	Member findMemberById(String member_id);
	
}
