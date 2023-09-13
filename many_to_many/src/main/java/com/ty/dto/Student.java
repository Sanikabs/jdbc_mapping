package com.ty.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany
	private List<Subject> subject;

}
