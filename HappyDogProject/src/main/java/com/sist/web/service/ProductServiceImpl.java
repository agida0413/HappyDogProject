package com.sist.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.ProductDAO;

import com.sist.web.entity.product_detail;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductDAO dao;

public Map mainList(){
	Map map =new HashMap<>();
	map.put("lPlist", dao.lowpriceList());
	map.put("hHlist", dao.highHitList());
	map.put("hGlist", dao.highGradeList());
	
	return map;
}

@Override
public Map productListData(String page,String ss) {
	Map map =new HashMap<>();
		if(ss==null) {
			ss="";
		}
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-rowSize;
	   List<product_detail> list=dao.product_lowerPrice(start,ss);
	   int count=dao.productCount(ss);
	   int totalpage=(int)(Math.ceil(count/12.0));
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	
	   map.put("list", list);
	   map.put("totalpage", totalpage);
	   map.put("startpage", startPage);
	   map.put("endpage", endPage);
	   map.put("page", curpage);
	   map.put("ss", ss);
	
	return map ;
}

@Transactional
@Override
public Map productDetailData(int pno,HttpServletRequest request) {
	
	Map map=new HashMap<>();
	 Cookie[] cookies=request.getCookies();
	   List<product_detail> cList=new ArrayList<product_detail>();
	   int k=0;
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   if(cookies[i].getName().startsWith("product"))
			   {
				   if(k>2)break;
				   String no=cookies[i].getValue();
				   product_detail c=dao.findByPno(Integer.parseInt(no));
				   cList.add(c);
				   k++;
			   }
		   }
	   }
	
	product_detail vo = dao.findByPno(pno);
	
	vo.setP_hit(vo.getP_hit()+1);
	map.put("vo", vo);
	map.put("clist", cList);
	return map;
}

@Override
public String cookieSend(int pno, RedirectAttributes ra, HttpServletResponse response) {
	// TODO Auto-generated method stub
	 Cookie cookie=new Cookie("product"+pno, String.valueOf(pno));
	   // cookie는 저장시에 문자열만 저장이 가능 
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   response.addCookie(cookie); // 클라이언트 브라우저로 전송 
	   ra.addAttribute("pno", pno);
	   return "redirect:../product/detail";
}


	

	
	
}
