package com.sist.web.service;

import java.util.Map;

import com.sist.web.entity.Dognews;

public interface DogNewsService {

	public Map dognewsListdata(String page);
	public Dognews dognewsDetail(int pno);
}
