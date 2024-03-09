package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dognews {

	@Id
	private int pno;
	private int hit;
	
	private String news_subject;
	private String news_img;
	private String news_content;
}
