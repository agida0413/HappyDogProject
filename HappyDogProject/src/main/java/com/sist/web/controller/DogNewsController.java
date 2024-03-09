package com.sist.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.Dognews;
import com.sist.web.entity.Pet_reply;
import com.sist.web.service.DogNewsService;
import com.sist.web.service.ReplyService;

@Controller
public class DogNewsController {

	@Autowired
	private DogNewsService service;
	
	@Autowired
	private ReplyService rService;
	
	@GetMapping("/dognews/list")
	public String dognews(String page,Model model) {
		Map map= service.dognewsListdata(page);
		model.addAttribute("totalpage", map.get("totalpage"));
		model.addAttribute("startpage", map.get("startpage"));
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("count",map.get("count"));
		model.addAttribute("main_html","dognews/list");
		return "main";
	}
	
	
	@GetMapping("/dognews/detail")
	public String dognewsDetail(int pno,Model model) {
		
		List<Pet_reply>list=rService.replyListData(pno);
			Dognews vo = service.dognewsDetail(pno);
			model.addAttribute("vo",vo);
			model.addAttribute("list",list);
		model.addAttribute("main_html","dognews/detail");
		return "main";
	}
}
