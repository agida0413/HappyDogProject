package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.product_detail;
import com.sist.web.entity.thmember;

@Repository
public interface MemberDAO  extends JpaRepository<thmember, String>{
	@Query(value = "SELECT COUNT(*) FROM thmember "
	+"WHERE id=:id",nativeQuery = true)
	public int memberIdCount(@Param("id") String id);
		@Query(value = "SELECT * FROM thmember WHERE id=:id",nativeQuery = true)
		public thmember memberInfo(@Param("id") String id);
	
	
}
