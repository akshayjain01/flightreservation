package com.project.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
