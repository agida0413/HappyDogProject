package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Pet_reply;

public interface ReplyService {
	public void replyInsert(Pet_reply vo,String id,String name);
	public void replyDelete(int pno,int no);
	public void replyUpdate(Pet_reply vo);
	public List<Pet_reply> replyListData(int pno);
}
