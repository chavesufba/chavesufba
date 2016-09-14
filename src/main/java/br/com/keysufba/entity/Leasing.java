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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "LOCACAO", schema = "SCHEMAA")
public class Leasing {

  private Integer id;
  private Room room;
  private Date startTime;
  private Date endTime;
  private Person person;
  
  Leasing() { // jpa only
    
  }
  
  public Leasing(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SALA_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Room getRoom() {
    return room;
  }

  public void setRoom(final Room room) {
    this.room = room;
  }

  @Column(name = "HORA_INICIO")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(final Date startTime) {
    this.startTime = startTime;
  }

  @Column(name = "HORA_FINAL")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(final Date endTime) {
    this.endTime = endTime;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PESSOA_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
