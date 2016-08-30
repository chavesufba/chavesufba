package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="professor")
@PrimaryKeyJoinColumn(name="id")
public class Teacher extends Person {
	
	
	@Id
	private Integer id;
	
	
	@Column(name="num_siap", nullable=false)
	private String siapNumber;
	
	@ManyToOne
	@JoinColumn(name="departamento_id", foreignKey=@ForeignKey(name="id"))
	private Department departmentId;
	
	
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
	public Department getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Department departmentId) {
		this.departmentId = departmentId;
	}
	
}
