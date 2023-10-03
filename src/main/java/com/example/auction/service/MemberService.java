package com.example.auction.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auction.model.Member;
import com.example.auction.model.RoleType;
import com.example.auction.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 회원정보 검색
	public Member findMemberById(String member_id) {
		return memberRepository.findMemberById(member_id);
	}
	
	// 회원정보 저장
	public void saveMember(Member member) {
		String rawpassword = member.getPassword();
		String encPassword = passwordEncoder.encode(rawpassword);
		member.setPassword(encPassword);
		// 기본 ROLE 부여
		member.setRole(RoleType.ROLE_USER);
		
		memberRepository.saveMember(member);
	}
}
