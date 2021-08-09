package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.domain.JoinRequest;
import com.bitcamp.op.member.service.JoinService;

@Controller
@RequestMapping("member/regform")
public class MemberRegController {
	
	
	@Autowired
	private JoinService joinService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String join(
			JoinRequest joinRequest,
			HttpServletRequest request
			) {
		
		System.out.println(joinRequest.getMemberid());
		System.out.println(joinRequest.getPassword());
		System.out.println(joinRequest.getMembername());
		System.out.println(joinRequest.getMembername());
		int result = joinService.joinMember(joinRequest, request);
		System.out.println(result);
		return "member/test";
	}
	
	
}
