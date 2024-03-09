package com.sist.web.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.ProductDAO;
import com.sist.web.entity.product_detail;
import com.sist.web.entity.product_sub_image;
import com.sist.web.service.ProductService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController {
@Autowired
private ProductService service;



	
@RequestMapping("/product/list")
public String productList(String page, Model model,String ss) {
	Map map=service.productListData(page,ss);
	
	model.addAttribute("totalpage", map.get("totalpage"));
	model.addAttribute("startpage", map.get("startpage"));
	model.addAttribute("endpage", map.get("endpage"));
	model.addAttribute("list", map.get("list"));
	model.addAttribute("page", map.get("page"));
	model.addAttribute("ss",map.get("ss"));
	  model.addAttribute("main_html", "product/list");
	return "main";
}


@GetMapping("/product/detail")
public String productdetail( int pno ,Model model,HttpServletRequest requset) {
	
		Map map =service.productDetailData(pno, requset);
		
		model.addAttribute("vo",map.get("vo"));
		model.addAttribute("clist",map.get("clist"));
	  model.addAttribute("main_html", "product/detail");
	return "main";
}


@GetMapping("/product/detail_before")
public String productdetailBefore( int pno,RedirectAttributes ra,HttpServletResponse response) {
	 
	return service.cookieSend(pno, ra, response);
	 

}
}
