package com.project.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.entities.Passenger;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repos.FlightRepository;
import com.project.flightreservation.repos.PassengerRepository;
import com.project.flightreservation.repos.ReservationRepository;
import com.project.flightreservation.util.EmailUtil;
import com.project.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		Long flightId = request.getFlightId();
		Optional<Flight> optionalFlight = flightRepository.findById(flightId);
		Flight flight = new Flight();
		if (optionalFlight.isPresent()) {
			 flight = optionalFlight.get();
		}
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		String filePath = System.getProperty("user.dir")+"/reservations/reservation⁩"+savedReservation.getId()+".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(reservation.getPassenger().getEmail(), filePath);
		return savedReservation;
	}

}
