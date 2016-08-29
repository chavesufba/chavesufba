package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.repository.RoomRepository;
import br.com.keysufba.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

  @Autowired
  private RoomRepository roomRepository;

  @RequestMapping("/rooms")
  public HttpEntity<List<Room>> getRooms() {
    final List<Room> rooms = roomRepository.findAll();
    return new ResponseEntity<>(rooms, HttpStatus.OK);
  }

  @RequestMapping("/rooms/{id}")
  public HttpEntity<Room> getRoom(@PathVariable("id") Integer id) {
    final Room room = roomRepository.findOne(id);
    if (room == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(room, HttpStatus.OK);
  }
  
}
