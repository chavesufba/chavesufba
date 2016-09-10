package br.com.keysufba.repository;

import br.com.keysufba.domain.BookingStatus;
import br.com.keysufba.entity.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
  
  List<Booking> findByStatus(BookingStatus status);
  
}
