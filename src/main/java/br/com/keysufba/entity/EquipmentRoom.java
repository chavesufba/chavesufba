package br.com.keysufba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "sala_equipamento")
public class EquipmentRoom {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name="quantidade")
	private Integer quantity;
	
	
	@ManyToOne
	@JoinColumn(name="equipamento_id", foreignKey=@ForeignKey(name="id"))
	private Equipment equipmentId;
	
	
	@ManyToOne
	@JoinColumn(name="sala_id", foreignKey=@ForeignKey(name="id"))
	private Room roomId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Equipment getEquipmentId() {
		return equipmentId;
	}


	public void setEquipmentId(Equipment equipmentId) {
		this.equipmentId = equipmentId;
	}


	public Room getRoomId() {
		return roomId;
	}


	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

}
