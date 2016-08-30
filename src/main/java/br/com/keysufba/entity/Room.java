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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "SALA", schema = "SCHEMAA")
public class Room {

  private Integer id;
  private String number;
  private Integer capacity;
  private Pavilion pavilion;
  private RoomType roomType;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  @NotNull
  @Length(max = 20)
  @Column(name = "NUMERO", length = 20, nullable = false)
  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  @Column(name = "CAPACIDADE")
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(final Integer capacity) {
    this.capacity = capacity;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PAVILHAO_ID", referencedColumnName = "ID", nullable = false)
  public Pavilion getPavilion() {
    return pavilion;
  }

  public void setPavilion(final Pavilion pavilion) {
    this.pavilion = pavilion;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TIPO_SALA_ID", referencedColumnName = "ID", nullable = false)
  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(final RoomType roomType) {
    this.roomType = roomType;
  }
}
