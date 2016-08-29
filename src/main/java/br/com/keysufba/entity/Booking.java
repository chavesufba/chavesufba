package br.com.keysufba.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Booking {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@OneToMany
	@JoinColumn(name="professor_Id")
	private Teacher teacherId;
	
	
	@OneToOne
	@JoinColumn(name="room_id", nullable=false)
	private Room roomId;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio", nullable=false)
	private Calendar beginTime;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_fim", nullable=false)
	private Calendar endTime;
	
	
	@OneToOne
	@JoinColumn(name="tecnico_id", nullable=false, foreignKey=@ForeignKey(name="id"))
	private Technician technicianId;
	
	
	@OneToOne
	@JoinColumn(name="status_reserva", nullable=false, foreignKey=@ForeignKey(name="id"))
	private BookingStatus bookingStatusId;
	
}
