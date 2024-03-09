package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.Dognews;
import com.sist.web.entity.thmember;

@Repository
public interface DogNewsDAO extends JpaRepository<Dognews, Integer> {

@Query(value="SELECT * FROM Dognews ORDER BY pno ASC LIMIT :start,12",nativeQuery = true)
public List<Dognews> dognewsList(@Param("start") int start);

@Query(value="SELECT COUNT(*) FROM DOGNEWS",nativeQuery = true)
public int dognewsCount();

public Dognews findByPno(int pno);
}
