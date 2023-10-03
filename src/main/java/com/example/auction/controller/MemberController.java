package com.example.auction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.auction.config.UserInfo;
import com.example.auction.model.JoinMemberForm;
import com.example.auction.model.LoginForm;
import com.example.auction.model.Member;
import com.example.auction.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
@Controller
public class MemberController {
	private final MemberService memberService;

    /**
     * 회원가입 페이지 이동
     * @param model
     * @return member/joinForm.html
     */
    @GetMapping("join")
    public String joinForm(Model model) {
        model.addAttribute("joinForm", new JoinMemberForm());
        return "member/joinForm";
    }

    /**
     * 회원가입
     * @param joinForm
     * @param bindingResult
     * @return
     */
    @PostMapping("join")
    public String join(@Validated @ModelAttribute("joinForm") JoinMemberForm joinForm, BindingResult bindingResult) {
        log.info("joinForm: {} ", joinForm);

        if (bindingResult.hasErrors()) {
            log.info("bindingResult: {}", bindingResult);
            return "member/joinForm";
        }

        // 동일한 아이디로 가입된 회원정보가 있는지 검색
        Member member = memberService.findMemberById(joinForm.getMember_id());
        if (member != null) {
            bindingResult.rejectValue("member_id","idDuplicateError", "이미 사용중인 아이디 입니다.");
            log.info("bindingResult: {}", bindingResult);
            return "member/joinForm";
        }

        // 회원정보를 저장한다.
        memberService.saveMember(JoinMemberForm.toMember(joinForm));

        return "redirect:/";
    }
    
    // 로그인이 성공하면 호출될 메소드
    @GetMapping("login-success")
    public String loginSuccess(@AuthenticationPrincipal UserInfo userInfo) {
    	log.info("로그인 성공, userInfoL {}", userInfo);
    	
    	return "redirect:/";
    }
    
    // 로그인이 실패하면 호출된 메소드
    @GetMapping("login-failed")
    public String loginFailed(Model model) {
    	log.info("로그인 실패");
    	model.addAttribute("loginForm",new LoginForm());
    	return "member/loginForm";
    }

    /**
     * 로그인 페이지 이동
     * @param model
     * @return
     */
    @GetMapping("login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "member/loginForm";
    }

    /**
     * 로그인
     * @param loginForm
     * @param bindingResult
     * @param request
     * @return
     */
    @PostMapping("login")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
                        HttpServletRequest request) {
        log.info("loginForm: {}", loginForm);

        if (bindingResult.hasErrors()) {
            return "member/loginForm";
        }

        Member member = memberService.findMemberById(loginForm.getMember_id());
        if (member == null || !member.getPassword().equals(loginForm.getPassword())) {
            bindingResult.reject("loginError", "아이디가 없거나 패스워드가 다릅니다.");
            return "member/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member);
        return "redirect:/";
    }

    /**
     * 로그아웃
     * @param request
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

}
