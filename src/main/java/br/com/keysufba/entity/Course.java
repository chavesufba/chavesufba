package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	@JoinColumn(name="dapartamento_id", foreignKey=@ForeignKey(name="id"))
	private Department departamentoId;
	
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Department getDepartamentoId() {
		return departamentoId;
	}
	public void setDepartamentoId(Department departamentoId) {
		this.departamentoId = departamentoId;
	}
}
