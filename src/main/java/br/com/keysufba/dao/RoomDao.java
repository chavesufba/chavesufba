package br.com.keysufba.dao;

import java.util.Arrays;
import java.util.List;

import br.com.keysufba.entity.Room;

public class RoomDao {

  public List<Room> getRooms() {
    return Arrays.asList(
      new Room(1, "10", 30, 1, 1),
      new Room(2, "11", 40, 1, 2),
      new Room(3, "12", 20, 2, 3),
      new Room(4, "13", 25, 2, 4),
      new Room(5, "14", 15, 3, 5),
      new Room(6, "15", 30, 4, 6)
    );
  }

  public Room getRoom(final Integer id) {
    for (final Room room : getRooms()) {
      if (room.getId().equals(id)) {
        return room;
      }
    }
    return null;
  }

}
