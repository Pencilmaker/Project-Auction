package com.example.auction.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.auction.config.UserInfo;
import com.example.auction.model.Member;
import com.example.auction.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		log.info("loadUserByUsername: {},", username);
		Member findMember = memberRepository.findMemberById(username);
		if (findMember != null) {
			return new UserInfo(findMember);
		}
		return null;
	}
}
