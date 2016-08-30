package br.com.keysufba.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA_USUARIO", schema = "SCHEMAA")
public class UserPerson {

  private Person person; // FIXME: Check the real necessity of this class
  private UserType userType;

  @ManyToMany
  @JoinColumn(name = "PESSOA_ID", referencedColumnName = "ID", nullable = false)
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @ManyToMany
  @JoinColumn(name = "TIPO_USUARIO_ID", referencedColumnName = "ID", nullable = false)
  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }
}
