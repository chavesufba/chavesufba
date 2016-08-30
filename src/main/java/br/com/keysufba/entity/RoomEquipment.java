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

@Entity
@Table(name = "SALA_EQUIPAMENTO", schema = "SCHEMAA")
public class RoomEquipment {

  private Integer id;
  private Integer quantity;
  private Equipment equipament;
  private Room room;

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
  @Column(name = "QUANTIDADE", nullable = false)
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(final Integer quantity) {
    this.quantity = quantity;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EQUIPAMENTO_ID", referencedColumnName = "ID", nullable = false)
  public Equipment getEquipament() {
    return equipament;
  }

  public void setEquipament(final Equipment equipament) {
    this.equipament = equipament;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "SALA_ID", referencedColumnName = "ID", nullable = false)
  public Room getRoom() {
    return room;
  }

  public void setRoom(final Room room) {
    this.room = room;
  }

}
