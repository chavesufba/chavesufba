package br.com.keysufba.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PESSOA", schema = "SCHEMAA")
public class Person {

  private Integer id;
  private String name;
  private String email;
  private String phone;
  private String photo;
  private Set<UserType> userTypes = new HashSet<UserType>(0);

  Person() { // jpa only

  }

  public Person(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "NOME", length = 100, nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "EMAIL", length = 100, nullable = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "TELEFONE", length = 20)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Column(name = "FOTO", length = 250)
  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "PESSOA_USUARIO", schema = "SCHEMAA", joinColumns = {
      @JoinColumn(name = "PESSOA_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
	  @JoinColumn(name = "TIPO_USUARIO_ID", nullable = false, updatable = false) })
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Set<UserType> getUserTypes() {
    return userTypes;
  }

  public void setUserTypes(Set<UserType> userTypes) {
    this.userTypes = userTypes;
  }
}
