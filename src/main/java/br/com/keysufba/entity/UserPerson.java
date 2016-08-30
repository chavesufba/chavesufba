package br.com.keysufba.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Pessoa_Usuario")
public class UserPerson {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name="tipo_usuario", nullable=false, foreignKey=@ForeignKey(name="id"))
	private UserType userTypeId;
	
	
	@ManyToOne
	@JoinColumn(name="pessoa_id", nullable=false, foreignKey=@ForeignKey(name="id"))
	private Person personId;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserType getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(UserType userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}
}
