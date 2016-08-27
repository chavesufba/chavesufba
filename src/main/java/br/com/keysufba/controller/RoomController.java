package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.dao.RoomDao;
import br.com.keysufba.model.Room;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class RoomController {

  private final RoomDao roomDao = new RoomDao();

  @RequestMapping("/rooms")
  public HttpEntity<List<Room>> getRooms() {
    final List<Room> rooms = roomDao.getRooms();
    for (final Room room : rooms) {
      room.add(linkTo(methodOn(RoomController.class).getRoom(room.getIdentification())).withSelfRel());
    }

    return new ResponseEntity<>(rooms, HttpStatus.OK);
  }

  @RequestMapping("/rooms/{id}")
  public HttpEntity<Room> getRoom(@PathVariable("id") Integer id) {
    final Room room = roomDao.getRoom(id);
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(room, HttpStatus.OK);
  }

}
