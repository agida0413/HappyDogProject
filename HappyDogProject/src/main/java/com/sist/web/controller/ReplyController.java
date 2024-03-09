package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.entity.Pet_reply;
import com.sist.web.service.ReplyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReplyController {
   @Autowired
   private ReplyService service;
   
   @PostMapping("/reply/insert")
   public String replyInsert(Pet_reply vo,HttpSession session,RedirectAttributes ra)
   {
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	 
	   service.replyInsert(vo,id,name);//insert
	   
	   ra.addAttribute("pno", vo.getPno());
	   return "redirect:/dognews/detail";
   }
   @GetMapping("/reply/delete")
   public String replyDelete(int pno,int no,RedirectAttributes ra)
   {
	  service.replyDelete(pno,no);
	 
	   ra.addAttribute("pno", pno);
	   return "redirect:/dognews/detail";
   }
   @PostMapping("/reply/update")
   public String replyUpdate(Pet_reply vo,RedirectAttributes ra)
   {
	   service.replyUpdate(vo);
	   ra.addAttribute("pno", vo.getPno());
	   return "redirect:/dognews/detail";
   }
   
}
