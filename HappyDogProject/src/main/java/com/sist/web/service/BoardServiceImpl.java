package com.sist.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;


@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	@Override
	public Map boardListData(String page) {
		// TODO Auto-generated method stub
		Map map =new HashMap<>();
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowsize=10;
		int start=(rowsize*curpage)-rowsize;
		List<BoardVO> list=dao.boardListData(start);
		int count=(int)dao.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		map.put("curpage", curpage);
		map.put("totalpage", totalpage);
		map.put("list", list);
		
		return map;
	}
	@Override
	public void save(Board vo) {
		// TODO Auto-generated method stub
		dao.save(vo);
	}
	@Override
	public Board findByNo(int no) {
		// TODO Auto-generated method stub
		
		  Board vo=dao.findByNo(no);
		   vo.setHit(vo.getHit()+1);
		   dao.save(vo);//insert,update를 동시에 처리 
		   // 조회수 증가 
		   vo=dao.findByNo(no);
		return vo;
	}
	
	public Board findByNo2(int no) {
		return dao.findByNo(no);
	}
	@Override
	public void delete(Board vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
		
		
	}

}
