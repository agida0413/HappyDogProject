package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class thmember {
	@Id
	@Column(name = "id",unique = true)
private String id;
private String pwd;
private String name;
}
