package br.com.keysufba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "SALA", schema = "SCHEMAA")
@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotNull
  @Column(name = "NUMERO")
  private String number;

  @NotNull
  @Column(name = "CAPACIDADE")
  private Integer capacity;

  @ManyToOne
  private Pavilion pavilion;

  @ManyToOne
  private RoomType roomType;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(final Integer capacity) {
    this.capacity = capacity;
  }

  public Pavilion getPavilion() {
    return pavilion;
  }

  public void setPavilion(final Pavilion pavilion) {
    this.pavilion = pavilion;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(final RoomType roomType) {
    this.roomType = roomType;
  }
}
