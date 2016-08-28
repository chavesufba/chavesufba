package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="Pessoa_Usuario")
public class UserPerson {
	
	@Column(name="pessoa_id", nullable=false)
	private Person personId;
	
	
	@Column(name="tipo_usuario", nullable=false)
	private UserType userTypeId;
	
	
	public Person getPersonId() {
		return personId;
	}
	public void setPersonId(Person personId) {
		this.personId = personId;
	}
	public UserType getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(UserType userTypeId) {
		this.userTypeId = userTypeId;
	}
}
