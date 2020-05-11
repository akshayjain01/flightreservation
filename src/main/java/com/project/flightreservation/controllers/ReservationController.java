package com.project.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.flightreservation.dto.ReservationRequest;
import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.entities.Reservation;
import com.project.flightreservation.repos.FlightRepository;
import com.project.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompeleteReservation")
	public String showCompeleteReservation(@RequestParam Long flightId,ModelMap modelMap) {
		Optional<Flight> optionalFlight = flightRepository.findById(flightId);
		if(optionalFlight.isPresent()) {
			Flight flight = optionalFlight.get();	
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
		}
		return "";
	}
	
	@RequestMapping(value = "completeReservation", method = RequestMethod.POST)
	public String completeReservation(@ModelAttribute("request") ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is : " +reservation.getId());
		return "reservationConfirmation";
		
	}

}
