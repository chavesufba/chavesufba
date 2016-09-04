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
  public Room create(Room t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Room delete(Room t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Room update(Room t) {
    // TODO Auto-generated method stub
    return null;
  }

}
