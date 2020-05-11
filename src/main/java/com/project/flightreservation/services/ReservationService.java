package com.project.flightreservation.services;

import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
}
