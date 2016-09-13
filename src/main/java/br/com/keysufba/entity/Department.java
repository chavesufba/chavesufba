package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "DEPARTAMENTO", schema = "SCHEMAA")
@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotNull
  @Column(name = "NOME")
  private String name;

  @ManyToOne
  private Institute institute;

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

  public Institute getInstitute() {
    return institute;
  }

  public void setInstitute(final Institute institute) {
    this.institute = institute;
  }
}
