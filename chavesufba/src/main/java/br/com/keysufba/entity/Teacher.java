package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="professor")
public class Teacher extends Person {
	@Id
	private Integer id;
	@Column(name="num_siap")
	private String siapNumber;
	@Column(name="departamento_id")
	private Integer departmentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSiapNumber() {
		return siapNumber;
	}
	public void setSiapNumber(String siapNumber) {
		this.siapNumber = siapNumber;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
}
