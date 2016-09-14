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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.keysufba.domain.RoomType;

@Entity
@Table(name = "SALA", schema = "SCHEMAA")
public class Room {

  private Integer id;
  private String number;
  private Integer capacity;
  private Pavilion pavilion;
  private RoomType roomType;
  private String equipmentDescription;

  Room() { // jpa only

  }

  public Room(Integer id) {
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

  @Column(name = "NUMERO", length = 20, nullable = false)
  public String getNumber() {
    return number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  @Column(name = "CAPACIDADE", nullable = false)
  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(final Integer capacity) {
    this.capacity = capacity;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PAVILHAO_ID", nullable = false)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  public Pavilion getPavilion() {
    return pavilion;
  }

  public void setPavilion(final Pavilion pavilion) {
    this.pavilion = pavilion;
  }

  @Column(name = "TIPO", length = 1, nullable = false)
  @Enumerated(EnumType.STRING)
  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(final RoomType roomType) {
    this.roomType = roomType;
  }

  @Column(name = "DESCRICAO_EQUIPAMENTOS", length = 255)
  public String getEquipmentDescription() {
    return equipmentDescription;
  }

  public void setEquipmentDescription(final String equipmentDescription) {
    this.equipmentDescription = equipmentDescription;
  }
}