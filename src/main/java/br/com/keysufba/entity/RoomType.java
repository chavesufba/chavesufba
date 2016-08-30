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

@Table(name = "TIPO_SALA", schema = "SCHEMAA")
@Entity
public class RoomType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotNull
  @Column(name = "DESCRICAO")
  private String description;

  @OneToMany(mappedBy = "roomType")
  private List<Room> rooms;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(final List<Room> rooms) {
    this.rooms = rooms;
  }
}
