package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {

@Autowired
private MemberService service;

@PostMapping("/member/login")
public String memberLogin(String id,String pwd,HttpSession session) {
	
	String result=service.memberLogin(id, pwd,session);
	return result;
	
}

@GetMapping("/member/logout")
public String memberLogout(HttpSession session) {
	String result="";
	try {
		result="YES";
		session.invalidate();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		result="NO";
	}
	return result;
}
}
