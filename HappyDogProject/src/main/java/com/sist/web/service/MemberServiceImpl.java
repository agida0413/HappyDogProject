package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.MemberDAO;
import com.sist.web.entity.thmember;

import jakarta.servlet.http.HttpSession;

@Service
public class MemberServiceImpl  implements MemberService{

	@Autowired
	private MemberDAO dao;

	@Override
	public String memberLogin(String id, String pwd,HttpSession session) {
		// TODO Auto-generated method stub
	String result="";
	int count=dao.memberIdCount(id);
	if(count==0) {
		result="NOID";
	}
	else {
		thmember vo =dao.memberInfo(id);
		if(pwd.equals(vo.getPwd())) {
		result="OK";	
		session.setAttribute("id", vo.getId());
		session.setAttribute("name", vo.getName());
		}
		else {
			result="NOPWD";
		}
	}
		
		return result;
	}
}
