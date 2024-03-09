package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;

public interface BoardService {

	public Map boardListData(String page);
	
	public void save(Board vo);
	
	public Board findByNo(int no);
	public Board findByNo2(int no);
	public void delete(Board vo);
}
