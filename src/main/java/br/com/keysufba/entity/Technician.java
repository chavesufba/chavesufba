package br.com.keysufba.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="tecnico")
@PrimaryKeyJoinColumn(name="id")
public class Technician extends Person {
	
	
	@Id
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="departamento_id", foreignKey=@ForeignKey(name="id"))
	private Department departmentId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	
}
