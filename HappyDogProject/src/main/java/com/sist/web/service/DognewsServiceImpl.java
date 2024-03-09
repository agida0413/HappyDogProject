package com.sist.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.DogNewsDAO;
import com.sist.web.entity.Dognews;
import com.sist.web.entity.product_detail;

import jakarta.transaction.Transactional;

@Service
public class DognewsServiceImpl implements DogNewsService{

	@Autowired
	private DogNewsDAO dao;
	@Override
	public Map dognewsListdata(String page) {
		Map map =new HashMap<>();
	
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-rowSize;
	   List<Dognews> list=dao.dognewsList(start);
	   int count=dao.dognewsCount();
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
	   map.put("count", count);

		return map;
	}
	@Transactional
	@Override
	public Dognews dognewsDetail(int pno) {
		// TODO Auto-generated method stub
		
		Dognews vo = dao.findByPno(pno);
		vo.setHit(vo.getHit()+1);
		
		return vo;
	}

	
}
