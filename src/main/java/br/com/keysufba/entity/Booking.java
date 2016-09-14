package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.com.keysufba.domain.BookingStatus;

import java.util.Date;

@Entity
@Table(name = "RESERVA", schema = "SCHEMAA")
public class Booking {

  private Integer id;
  private Teacher teacher;
  private Room room;
  private Date startTime;
  private Date endTime;
  private Technician technician;
  private BookingStatus status;
  
  Booking() { // jpa only
    
  }
  
  public Booking(Integer id) {
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
  @JoinColumn(name = "PROFESSOR_ID")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SALA_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  @Column(name = "HORA_INICIO")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @Column(name = "HORA_FINAL")
  @Temporal(TemporalType.TIMESTAMP)
  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TECNICO_ID")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Technician getTechnician() {
    return technician;
  }

  public void setTechnician(Technician technician) {
    this.technician = technician;
  }

  @Column(name = "STATUS_RESERVA", length = 1)
  @Enumerated(EnumType.STRING)
  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

}
