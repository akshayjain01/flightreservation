package com.project.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.flightreservation.entities.Flight;
import com.project.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping(value = "findFlights", method = RequestMethod.POST)
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to, 
							  @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,ModelMap modelMap )
	{
		System.out.println(from+", "+to+", "+departureDate);
		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}
	
}
