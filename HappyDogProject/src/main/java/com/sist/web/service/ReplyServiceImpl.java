package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.ReplyDAO;
import com.sist.web.entity.Pet_reply;

import jakarta.servlet.http.HttpSession;
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private ReplyDAO dao;
	
public void replyInsert(Pet_reply vo,String id,String name) {
	vo.setId(id);
	vo.setName(name);
	dao.save(vo);
	
}

public void replyDelete(int pno,int no) {
	Pet_reply vo=dao.findByNo(no);
	dao.delete(vo);
}

public void replyUpdate(Pet_reply vo) {
	dao.save(vo);
}

@Override
public List<Pet_reply> replyListData(int pno) {
	// TODO Auto-generated method stub
	return dao.replyListData(pno);
}
}
