package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.entity.product_detail;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ProductService {

	public Map mainList();
	
	public Map productListData(String page,String ss);

	
	public String cookieSend(int pno,RedirectAttributes ra,HttpServletResponse response);
	public Map productDetailData(int pno,HttpServletRequest request);
}
