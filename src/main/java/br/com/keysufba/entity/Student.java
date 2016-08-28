package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="aluno")
@PrimaryKeyJoinColumn(name="id")
public class Student extends Person {
	
	
	@Id
	private Integer id;
	
	
	@Column(name="matricula", nullable=false)
	private String registrationNum;
	
	
	@Column(name="curso_id", nullable=false)
	private Integer courseId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
}
