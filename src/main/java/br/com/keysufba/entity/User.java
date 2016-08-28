package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="usuario")
public class User {
	
	
	@Id
	private Integer id;
	
	
	@Column(name="nome", nullable=false)
	private String name;
	
	
	@Column(name="senha", nullable=false)
	private String password;
	
	@ManyToOne
	@Column(name="pessoa_id", nullable=false)
	private Person personId;
	
	
	public User (Integer id, String name) {
        this.id = id;
        this.name = name;
    }
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Person getPersonId() {
		return personId;
	}
	public void setPersonId(Person personId) {
		this.personId = personId;
	}
}
