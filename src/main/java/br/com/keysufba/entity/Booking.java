package br.com.keysufba.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="professor_Id")
	private Teacher teacherId;
	private Room roomId;
	private Calendar beginTime;
	private Calendar endTime;
	private Technician technicianId;
	private BookingStatus bookingStatusId;
	
}
