package br.com.keysufba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.keysufba.entity.Room;
import br.com.keysufba.service.RoomService;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

  @Autowired
  private RoomService roomService;

  @RequestMapping("/rooms")
  public HttpEntity<List<Room>> getRooms() {
    final List<Room> rooms = roomService.findAll();
    return new ResponseEntity<>(rooms, HttpStatus.OK);
  }

  @RequestMapping("/rooms/{id}")
  public HttpEntity<Room> getRoom(@PathVariable("id") Integer id) {
    final Room room = roomService.findById(id);
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(room, HttpStatus.OK);
  }

  @RequestMapping(path = "/rooms", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Room> createRoom(@RequestBody Room room) throws DataIntegrityViolationException {
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      roomService.create(room);
      return new ResponseEntity<>(room, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/rooms", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Room> updateRoom(@RequestBody Room room) {
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Room updatedRoom = roomService.update(room);
      return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/rooms", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Room> deleteRoom(@RequestBody Room room) throws DataIntegrityViolationException {
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Room deletedRoom = roomService.delete(room);
      return new ResponseEntity<>(deletedRoom, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
