package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.IdCheckService;

@Controller
public class IdcheckController {
	
	@Autowired
	private IdCheckService checkService;
	
	@RequestMapping(value = "/member/idCheck")
	public String idCheck(
			@RequestParam("mid") String uid,
			Model model
			) {
		
		model.addAttribute("result", checkService.idCheck(uid));
		return "member/idcheck";
	}
	
	
}