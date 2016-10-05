package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PROFESSOR", schema = "SCHEMAA")
public class Teacher {

  private Integer id;
  private String siap;
  private Department department;
  private Person person;
  private Boolean visitor;

  Teacher() { // jpa only

  }

  public Teacher(Integer id) {
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

  @Column(name = "NUM_SIAP", length = 20, nullable = false)
  public String getSiap() {
    return siap;
  }

  public void setSiap(String siap) {
    this.siap = siap;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DEPARTAMENTO_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PESSOA_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Type(type = "boolean")
  @Column(name = "PROFESSOR_VISITANTE", nullable = false)
  public Boolean getVisitor() {
    return visitor;
  }

  public void setVisitor(Boolean visitor) {
    this.visitor = visitor;
  }

}