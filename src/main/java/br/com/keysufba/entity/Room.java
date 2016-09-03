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
  private RoomType type;

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

  @Column(name = "CAPACIDADE")
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
  public RoomType getType() {
    return type;
  }

  public void setType(final RoomType type) {
    this.type = type;
  }
}
