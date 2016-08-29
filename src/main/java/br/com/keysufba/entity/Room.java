package br.com.keysufba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="sala")
public class Room {

	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  
  @Column(name = "numero", nullable=false)
  private String number;

  
  @Column(name = "capacidade")
  private Integer capacity;

  
  @OneToOne
  @JoinColumn(name = "pavilhao_id", foreignKey=@ForeignKey(name="id"))
  private Pavilion pavilionId;

  
  @OneToOne
  @JoinColumn(name = "tipo_sala_id")
  private RoomType roomTypeId;

  
  Room() { // jpa only

  }

  public Room(final Integer id, final String number, final Integer capacity, final Pavilion pavilionId, final RoomType roomType) {
    this.id = id;
    this.number = number;
    this.capacity = capacity;
    this.pavilionId = pavilionId;
    this.roomTypeId = roomType;
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

  public Pavilion getPavilionId() {
    return pavilionId;
  }

  public RoomType getRoomType() {
    return roomTypeId;
  }
}
