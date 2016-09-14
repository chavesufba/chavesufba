package br.com.keysufba.controller;

import java.util.List;

import br.com.keysufba.domain.BookingStatus;
import br.com.keysufba.entity.Booking;
import br.com.keysufba.service.BookingService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @RequestMapping(method = RequestMethod.GET)
  public HttpEntity<List<Booking>> getBookings(@RequestParam(value="status", defaultValue = "") BookingStatus status) {
    if (status == null || StringUtils.isBlank(status.getDescryption())) {
      final List<Booking> bookings = bookingService.findAll();
      return new ResponseEntity<>(bookings, HttpStatus.OK);
    } else {
      final List<Booking> bookings = bookingService.findByStatus(status);
      return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public HttpEntity<Booking> getBooking(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    final Booking booking = bookingService.findById(id);
    if (booking == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(booking, HttpStatus.OK);
  }
  
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Booking> createBooking(@RequestBody Booking booking) {
    if (booking == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Booking createdBooking = bookingService.create(booking);
      return new ResponseEntity<>(createdBooking, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Booking> updateBooking(@PathVariable("id") Integer id, @RequestBody Booking booking) {
    if (id == null || booking == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      booking.setId(id);
      final Booking updatedBooking = bookingService.update(booking);
      if (updatedBooking == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public HttpEntity<Booking> deleteBooking(@PathVariable("id") Integer id) {
    if (id == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    try {
      final Integer deletedId = bookingService.delete(id);
      return new ResponseEntity<>(new Booking(deletedId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
