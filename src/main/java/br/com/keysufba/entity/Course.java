package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CURSO", schema = "SCHEMAA")
public class Course {

  private Integer id;
  private String name;
  private String level;
  private Department department;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  @Column(name = "NOME", length = 100, nullable = false)
  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Column(name = "NIVEL", length = 50, nullable = false)
  public String getLevel() {
    return level;
  }

  public void setLevel(final String level) {
    this.level = level;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DEPARTAMENTO_ID", nullable = false)
  public Department getDepartment() {
    return department;
  }

  public void setDepartment(final Department department) {
    this.department = department;
  }

}
