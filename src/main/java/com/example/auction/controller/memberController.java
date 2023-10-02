package com.example.auction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.auction.model.member.Login;
import com.example.auction.model.member.Member;
import com.example.auction.repository.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class memberController {

	private final MemberMapper memberMapper;

	// 회원가입 페이지
	@GetMapping("join")
	public String joinForm(Model model) {
		log.info("회원가입 페이지");
		model.addAttribute("member", new Member());
		return "member/joinForm";
	}
	
	// 회원가입
	@PostMapping("join")
	public String join(@Validated @ModelAttribute("member") Member member) {

		log.info("입력 값:{}", member);

		Member idcheck = memberMapper.findMember(member.getMember_id());

		if (idcheck != null) {
			log.info("이미 가입된 아이디");
			return "member/joinForm";
		}

		memberMapper.saveMember(member);

		return "redirect:/";
	}
	
	// 로그인 페이지
	@GetMapping("login")
	public String loginForm(Model model, HttpServletRequest request) {

//		// 로그인 확인
//		HttpSession session = request.getSession(true);
//		if (session != null) {
//			log.info("이미 로그인() 된 상태");
//			return "redirect:/";
//		}
		
		log.info("로그인 페이지");
		// 로그인 껍데기
		model.addAttribute("login", new Login());
		
		return "member/login";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(@Validated @ModelAttribute("loginForm") Login login,
			HttpServletResponse response, HttpServletRequest request) {
		
		
		Member idCheck = memberMapper.findMember(login.getMember_id());
		if (idCheck == null || !login.getPassword().equals(idCheck.getPassword())) {
			log.info("로그인 실패");
			return "redirect:member/login";
		}
		
		// request 객체에서 session 객체를 꺼내옴
		HttpSession session = request.getSession();
		// session에 'loginMember' 라는 이름으로 Member 객체를 저장
		session.setAttribute("loginMember", idCheck);
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
}
