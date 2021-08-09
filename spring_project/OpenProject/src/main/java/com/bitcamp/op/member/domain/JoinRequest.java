package com.bitcamp.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class JoinRequest {
	private String memberid;
	private String password;
	private String membername;
	private MultipartFile memberphoto;
	
	public JoinRequest() {}
	public JoinRequest(String memberid, String password, String membername, MultipartFile memberphoto) {
		this.memberid = memberid;
		this.password = password;
		this.membername = membername;
		this.memberphoto = memberphoto;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public MultipartFile getMemberphoto() {
		return memberphoto;
	}
	public void setMemberphoto(MultipartFile memberphoto) {
		this.memberphoto = memberphoto;
	}
	@Override
	public String toString() {
		return "JoinRequest [memberid=" + memberid + ", password=" + password + ", membername=" + membername
				+ ", memberphoto=" + memberphoto + "]";
	}
	public Member getMember() {
		return new Member(this.memberid, this.password, this.membername, this.memberphoto.getOriginalFilename());
	}
	
	
}
