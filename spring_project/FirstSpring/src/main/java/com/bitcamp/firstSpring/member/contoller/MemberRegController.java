package com.bitcamp.firstSpring.member.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.JoinRequest;

@Controller
@RequestMapping("/member/regform")
public class MemberRegController {

	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}
	
	
//	@RequestMapping("/member/regform")
	@RequestMapping(method = RequestMethod.POST)
	public String join(
			@RequestParam("memberid") String id,
			@RequestParam("password") String pw,
			@RequestParam("membername") String name,
			@RequestParam("photo") String photo,
			
			HttpServletRequest request,
			
			JoinRequest joinRequest,
			
			Model model
			) {
		
		// 단일 request
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("name", name);
		model.addAttribute("photo", photo);
		
		// 이너테이션 사용안하고 하나씩 값받을때
		String uid = request.getParameter("memberid");
		String upw = request.getParameter("password");
		String uname = request.getParameter("membername");
		String uphoto = request.getParameter("photo");
		
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
		model.addAttribute("uname", uname);
		model.addAttribute("uphoto", uphoto);
		
		
		// 객체 사용 한방에~
		System.out.println(joinRequest);
		
		
		return "member/memberList";
	}
	
}
