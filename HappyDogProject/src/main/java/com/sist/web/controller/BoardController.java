package com.sist.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.entity.Board;
import com.sist.web.service.BoardService;

@Controller
public class BoardController {
@Autowired
private BoardService service;
	@GetMapping("/board/list")
	public String boardList(String page,Model model) {
		Map map =service.boardListData(page);
		
		
		model.addAttribute("list",map.get("list"));
		model.addAttribute("totalpage",map.get("totalpage"));
		model.addAttribute("curpage",map.get("curpage"));
		model.addAttribute("main_html","board/list");
		return "main";
	}
	
	
	@GetMapping("/board/insert")
	public String boardinsert(Model model) {

		
		model.addAttribute("main_html","board/insert");
		return "main";
	}
	
	@PostMapping("/board/insert_ok")
	public String boardinsert_ok(Board vo) {

		service.save(vo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/detail")
	  public String board_detail(int no,Model model)
	   {
		 Board vo = service.findByNo(no);
		 model.addAttribute("main_html","board/detail");
		   model.addAttribute("vo", vo);
		   return "main";
	   }
	
	@GetMapping("/board/update")
	  public String board_update(int no,Model model)
	   {
		 Board vo = service.findByNo2(no);
		 model.addAttribute("main_html","board/update");
		   model.addAttribute("vo", vo);
		   return "main";
	   }
	
	
	@PostMapping("/board/update_ok")
	public String boardUpdateok(Board vo) {
		service.save(vo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(int no) {
		Board vo= service.findByNo2(no);
		service.delete(vo);
		
		return "redirect:/board/list";
	}
}
