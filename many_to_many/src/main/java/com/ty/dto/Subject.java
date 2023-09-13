package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Subject {
	@Id
	private int id;
	private String name;

}
