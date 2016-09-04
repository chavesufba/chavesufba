package br.com.keysufba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.keysufba.entity.Room;
import br.com.keysufba.repository.RoomRepository;

@Service("roomService")
public class RoomService implements GenericService<Room> {

  @Autowired
  private RoomRepository roomRepository;
  
  @Override
  public List<Room> findAll() {
    return roomRepository.findAll();
  }

  @Override
  public Room findById(Integer id) {
    return roomRepository.findOne(id);
  }

  @Override
  public Room create(Room r) {
    roomRepository.save(r);
    return r;
  }

  @Override
  public Room delete(Room r) {
    roomRepository.delete(r);
    return r;
  }

  @Override
  public Room update(Room r) {
    final Room foundRoom = findById(r.getId());
    if (foundRoom == null) {
      return null;
    }

    roomRepository.save(r);
    return r;
  }

}
