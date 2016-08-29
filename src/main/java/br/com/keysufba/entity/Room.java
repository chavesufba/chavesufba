package br.com.keysufba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SALA", schema = "SCHEMAA")
@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NUMERO")
  private String number;

  @Column(name = "CAPACIDADE")
  private Integer capacity;

  @Column(name = "PAVILHAO_ID")
  private Integer pavilionId;

  @Column(name = "TIPO_SALA_ID")
  private Integer roomType;

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
