package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.sist.web.entity.*;
public interface ReplyDAO extends JpaRepository<Pet_reply, Integer>{
   // 데이터 읽기
   @Query(value="SELECT * FROM pet_reply WHERE pno=:pno ORDER BY pno DESC",
		 nativeQuery = true)
   public List<Pet_reply> replyListData(@Param("pno") int pno);
   
   public Pet_reply findByNo(int no);
   // insert , update , delete 
}