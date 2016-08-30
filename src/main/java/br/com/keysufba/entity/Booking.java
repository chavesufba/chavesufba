package br.com.keysufba.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="reserva")
public class Booking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@OneToOne
	@JoinColumn(name="professor")
	private Teacher teacherId;
	
	
	@OneToOne
	@JoinColumn(name="room", nullable=false)
	private Room roomId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio")
	private Calendar beginTime;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_fim")
	private Calendar endTime;
	
	
	@OneToOne
	@JoinColumn(name="tecnico", foreignKey=@ForeignKey(name="id"))
	private Technician technicianId;
	
	
	@OneToOne
	@JoinColumn(name="status_reserva", foreignKey=@ForeignKey(name="id"))
	private BookingStatus bookingStatusId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Teacher getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}


	public Room getRoomId() {
		return roomId;
	}


	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}


	public Calendar getBeginTime() {
		return beginTime;
	}


	public void setBeginTime(Calendar beginTime) {
		this.beginTime = beginTime;
	}


	public Calendar getEndTime() {
		return endTime;
	}


	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}


	public Technician getTechnicianId() {
		return technicianId;
	}


	public void setTechnicianId(Technician technicianId) {
		this.technicianId = technicianId;
	}


	public BookingStatus getBookingStatusId() {
		return bookingStatusId;
	}


	public void setBookingStatusId(BookingStatus bookingStatusId) {
		this.bookingStatusId = bookingStatusId;
	}
	
}
