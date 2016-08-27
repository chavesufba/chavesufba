package br.com.keysufba.model;

public class Room {

  private final Integer id;
  private final String number;
  private final Integer capacity;
  private final Integer pavilionId;
  private final Integer roomType;

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
