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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TECNICO", schema = "SCHEMAA")
public class Technician {

  private Integer id;
  private Department department;
  private Person person;

  Technician() { // jpa only

  }

  public Technician(Integer id) {
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

}