package com.sist.web.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * PNO int 
P_NAME text 
P_GRADE double 
P_PRICE text 
P_IMAGE text 
P_PERCENT text 
P_LOWER_PRICE text 
P_SHIPMENT text 
P_CATEGORY text 
P_EXPIRE_DATE text 
P_DETAIL_IMAGE text 
P_HIT int 
P_INTPRICE int 
P_INTPERCENT int 
P_INTLOWERPRICE int
 * 
 */
@Entity
@Data
@NoArgsConstructor
public class product_detail {
@Id
private int pno;
private int p_hit,p_intprice,p_intpercent,p_intlowerprice;
private double p_grade;
private String p_name,p_price,p_image,p_percent,p_lower_price,p_shipment,p_category,
p_expire_date,p_detail_image;

@OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<product_sub_image> subImages = new ArrayList<>();
}
