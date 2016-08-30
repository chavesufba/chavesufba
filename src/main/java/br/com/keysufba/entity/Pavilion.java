package br.com.keysufba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "PAVILHAO", schema = "SCHEMAA")
@Entity
public class Pavilion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotNull
  @Column(name = "NOME")
  private String name;

  @OneToMany(mappedBy = "pavilion")
  private List<Room> roomList;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public List<Room> getRoomList() {
    return roomList;
  }

  public void setRoomList(final List<Room> roomList) {
    this.roomList = roomList;
  }
}
