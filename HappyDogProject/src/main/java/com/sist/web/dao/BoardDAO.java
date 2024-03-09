package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;
@Repository
public interface BoardDAO extends JpaRepository<Board, Integer> {

	public Board findByNo(int no);
	@Query(value="SELECT no,subject,name,content,hit,regdate "
			+"FROM BOARD order by no DESC "
			+"LIMIT :start,10",nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start);
	
	
}
