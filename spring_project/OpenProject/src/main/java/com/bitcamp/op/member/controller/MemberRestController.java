package com.bitcamp.op.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.service.MemberRestService;

//@Controller
// json 컨트롤러
@RestController
public class MemberRestController {
	
	@Autowired
	private MemberRestService restService;
	
	@RequestMapping("/members/{id}")
	@ResponseBody
	public Member getMember(
			@PathVariable("id") int idx
			) {
		
		Member member = restService.getMember(idx);
		System.out.println(member);
		
		return member;
	}
	
	
	@GetMapping("/members")
	public List<Member> getMembers(){
		return restService.getMembers();
	}
	
	
	@GetMapping("/members1")
	public Map<Integer, Member> getMembers1(){
		return restService.getMembers1();
	}
}
