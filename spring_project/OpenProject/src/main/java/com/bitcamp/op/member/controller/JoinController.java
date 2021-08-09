package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.domain.Report;
import com.bitcamp.op.member.service.JoinService;

@Controller
@RequestMapping("/member/join")
public class JoinController {

	@Autowired
	private JoinService joinService;

	@RequestMapping(method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(
			Report report,
			HttpServletRequest request
			) {
		
		System.out.println(report);
		joinService.join(report, request);
		return "member/join";
	}



}
