package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.product_detail;
@Repository
public interface ProductDAO  extends JpaRepository<product_detail, Integer>{


	@Query(value="SELECT * from product_detail ORDER BY p_intlowerprice ASC LIMIT 0,3",nativeQuery = true)
	public List<product_detail> lowpriceList();
	
	@Query(value="SELECT * from product_detail ORDER BY p_hit DESC LIMIT 0,1 " ,nativeQuery = true)
	public product_detail highHitList();
	
	@Query(value="SELECT * from product_detail ORDER BY p_grade DESC LIMIT 0,3" ,nativeQuery = true)
	public List<product_detail> highGradeList();
	
	@Query(value="SELECT * from product_detail WHERE p_name LIKE CONCAT('%',:ss,'%') ORDER BY p_intlowerprice DESC LIMIT :start,12" ,nativeQuery = true)
	public List<product_detail> product_lowerPrice(@Param("start") int start,@Param("ss") String ss);
	
	@Query(value="SELECT COUNT(*) from product_detail WHERE p_name LIKE CONCAT('%',:ss,'%')")
	public int productCount(String ss);
	
	public product_detail findByPno(int pno);
	
	
}
