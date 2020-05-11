package com.project.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightreservation.dto.updateReservationRequest;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findreservation(@PathVariable("id") Long id) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		if (optionalReservation.isPresent()) {
			Reservation reservation = optionalReservation.get();
			return reservation;
		}
		return null;
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody updateReservationRequest request) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(request.getId());
		Reservation reservation = new Reservation();
		if (optionalReservation.isPresent())
			reservation = optionalReservation.get();
		reservation.setNoOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}
}
