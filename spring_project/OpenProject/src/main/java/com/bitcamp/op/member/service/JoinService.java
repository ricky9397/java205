package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.JoinRequest;

@Service
public class JoinService {

	final String UPLOAD_URI = "/uploadfile";

	@Autowired
	MemberDao dao;

	public int joinMember(JoinRequest requestMember, HttpServletRequest request) {
		int result = 0;
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			saveFile(request, requestMember.getMemberphoto());
			result = dao.insertMember(conn, requestMember.getMember());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private void saveFile(HttpServletRequest request, MultipartFile file) throws IllegalStateException, IOException {
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		File newFile = new File(saveDir, file.getOriginalFilename());
		file.transferTo(newFile);
	}
}
