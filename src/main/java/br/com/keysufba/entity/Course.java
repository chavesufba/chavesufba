package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="curso")
public class Course {
	
	@Id
	private Integer id;
	@Column(name="nome")
	private String name;
	@Column(name="nivel")
	private String level;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNivel() {
		return level;
	}
	public void setNivel(String level) {
		this.level = level;
	}
}
