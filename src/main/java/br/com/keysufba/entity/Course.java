package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="curso")
public class Course {
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name="nome", nullable=false)
	private String name;
	
	
	@Column(name="nivel", nullable=false)
	private String level;
	
	@ManyToOne
	private Course courseId;
	
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
