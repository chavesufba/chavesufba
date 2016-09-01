package br.com.keysufba.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO", schema = "SCHEMAA")
public class UserType {

  private Integer id;
  private String description;
  private Set<Person> people = new HashSet<Person>(0);

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  @Column(name = "DESCRICAO", length = 50, nullable = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "userTypes")
  public Set<Person> getPeople() {
    return people;
  }
  
  public void setPeople(Set<Person> people) {
    this.people = people;
  }
}
