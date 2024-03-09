package com.sist.web.service;

import jakarta.servlet.http.HttpSession;

public interface MemberService {

	public String memberLogin(String id,String pwd,HttpSession session);
}
