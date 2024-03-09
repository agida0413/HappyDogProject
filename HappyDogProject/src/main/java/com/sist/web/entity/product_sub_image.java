package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * PSNO int 
PNO int 
P_SUB_IMAGE text
 */
@Entity
@Data
@NoArgsConstructor
public class product_sub_image {
	@Id
	private int psno;
	
	
	  @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "pno")
	    private product_detail productDetail;
	private String p_sub_image;
}
