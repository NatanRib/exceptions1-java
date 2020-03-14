package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		//TimeUnit é uma classe que serve para cobersao de unidades de tempo
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		//agora a logica de validação veio para o metodo responsavel
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}if(checkOut.before(checkIn)){
			return "Error in resevation: check-out date munst be after check-in date";	
		}else {
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			return null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Rerservation: Room ");
		sb.append(this.roomNumber);
		sb.append(", check-in: ");
		sb.append(sdf.format(checkIn));
		sb.append(", check-ot: ");
		sb.append(sdf.format(checkOut));
		sb.append(", ");
		sb.append(this.duration());
		sb.append(" nights");
		return sb.toString();
	}
}
