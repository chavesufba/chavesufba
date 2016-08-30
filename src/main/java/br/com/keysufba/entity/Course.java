package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "CURSO", schema = "SCHEMAA")
@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotNull
  @Column(name = "NOME")
  private String name;

  @NotNull
  @Column(name = "NIVEL")
  private String level;

  @ManyToOne
  private Department department;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(final String level) {
    this.level = level;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(final Department department) {
    this.department = department;
  }
}
