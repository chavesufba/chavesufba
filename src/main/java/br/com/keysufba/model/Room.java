package br.com.keysufba.model;

import org.springframework.hateoas.ResourceSupport;

public class Room extends ResourceSupport {

  private final Integer identification;
  private final String number;
  private final Integer capacity;
  private final Integer pavilionId;
  private final Integer roomType;

  public Room(final Integer identification, final String number, final Integer capacity, final Integer pavilionId, final Integer roomType) {
    this.identification = identification;
    this.number = number;
    this.capacity = capacity;
    this.pavilionId = pavilionId;
    this.roomType = roomType;
  }

  public Integer getIdentification() {
    return identification;
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
