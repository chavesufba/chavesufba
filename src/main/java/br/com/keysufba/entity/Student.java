package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="aluno")
@PrimaryKeyJoinColumn(name="id")
public class Student extends Person {
	
	
	@Id
	private Integer id;
	
	
	@Column(name="matricula", nullable=false)
	private String registrationNum;
	
	@OneToOne
	@JoinColumn(name="curso_id", nullable=false, foreignKey=@ForeignKey(name="id"))
	private Course courseId;
	
	
	@ManyToOne
	@JoinColumn(name="departamento_id", foreignKey=@ForeignKey(name="id"))
	private Department departmentId;
	
	
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
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	
}
