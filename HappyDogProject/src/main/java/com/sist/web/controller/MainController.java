package com.sist.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.product_detail;
import com.sist.web.service.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService service;
   @GetMapping("/")
   public String main_page(Model model)
   {
	Map map =service.mainList();
	
	model.addAttribute("lPlist", map.get("lPlist"));
	model.addAttribute("hHlist", map.get("hHlist"));
	model.addAttribute("hGlist", map.get("hGlist"));

	   model.addAttribute("main_html", "main/home");
	   return "main";
   }
}