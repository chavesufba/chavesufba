package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="tecnico")
@PrimaryKeyJoinColumn(name="id")
public class Technician extends Person {
	
	
	@Id
	private Integer id;
	
	
	@Column(name="department_id", nullable=false)
	private Integer departmentId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
}
