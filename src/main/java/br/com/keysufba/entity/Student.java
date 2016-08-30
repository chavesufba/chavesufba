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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ALUNO", schema = "SCHEMAA")
public class Student {

  private Integer id;
  private String registrationNumber;
  private Person person;
  private Course course;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @NotNull
  @Length(max = 20)
  @Column(name = "MATRICULA", length = 20, nullable = false)
  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PESSOA_ID", referencedColumnName = "ID", nullable = false)
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "CURSO_ID", referencedColumnName = "ID", nullable = false)
  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
}
