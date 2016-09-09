package br.com.keysufba.service;

import java.util.List;

import br.com.keysufba.entity.Booking;
import br.com.keysufba.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookingService")
public class BookingService implements GenericService<Booking>{

  @Autowired
  private BookingRepository bookingRepository;

  @Override
  public List<Booking> findAll() {
    return bookingRepository.findAll();
  }

  @Override
  public Booking findById(Integer id) {
    return bookingRepository.findOne(id);
  }

  @Override
  public Booking create(Booking t) {
    return bookingRepository.save(t);
  }

  @Override
  public Integer delete(Integer id) {
    bookingRepository.delete(id);
    return id;
  }

  @Override
  public Booking update(Booking t) {
    final Booking foundBooking = findById(t.getId());
    if(foundBooking == null){
      return null;
    }

    bookingRepository.save(t);
    return t;
  }

}
