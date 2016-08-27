package br.com.keysufba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "schemaA.sala")
@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "numero")
  private String number;

  @Column(name = "capacidade")
  private Integer capacity;

  @Column(name = "pavilhao_id")
  private Integer pavilionId;

  @Column(name = "tipo_sala_id")
  private Integer roomType;

  Room() { // jpa only

  }

  public Room(final Integer id, final String number, final Integer capacity, final Integer pavilionId, final Integer roomType) {
    this.id = id;
    this.number = number;
    this.capacity = capacity;
    this.pavilionId = pavilionId;
    this.roomType = roomType;
  }

  public Integer getId() {
    return id;
  }

  public String getNumber() {
    return number;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public Integer getPavilionId() {
    return pavilionId;
  }

  public Integer getRoomType() {
    return roomType;
  }
}
