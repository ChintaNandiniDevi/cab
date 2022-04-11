package com.cap.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.cb.entities.Driver;
import com.cap.cb.entities.TripBooking;
import com.cap.cb.service.DriverService;
import com.cap.cb.service.TripBookingService;


@RestController
@RequestMapping("/api/c5")
public class TripBookingController {

	@Autowired
	private TripBookingService tripBookingService;
	
	//insertTripBooking
	@PostMapping("/saveTrip")
	public ResponseEntity<TripBooking> insertTripBooking(
			@RequestBody TripBooking tripBooking){
		TripBooking trip = tripBookingService.insertTripBooking(null);
		if(trip== null)
		{
			return new ResponseEntity("Sorry! trip not available!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.OK);
	}
	
	//updateTripBooking
	@PutMapping("/putTrip")
	public ResponseEntity<TripBooking> updateTripBooking(
			@RequestBody TripBooking tripBooking){
		TripBooking trip = tripBookingService.updateTripBooking(null);
		if(trip == null)
		{
			return new ResponseEntity("Sorry! Trip not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.OK);
	}
	
	//deleteTripBooking
	@DeleteMapping("/delTrip/{tripBookingId}")
	public ResponseEntity<TripBooking> deleteTripBooking(
			@PathVariable("tripBookingId")Integer tripBookingId){
		TripBooking trip = tripBookingService.deleteTripBooking(tripBookingId);
		if(trip ==null) {
			return new ResponseEntity("Sorry! tripBookingId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.OK);
	}
	
//viewAllTripsCustomer
	@GetMapping("/getAllTripBookings")
	public ResponseEntity<List<TripBooking>> viewAll(
			@PathVariable("customerId")Integer customerId){
		List<TripBooking> trips = tripBookingService.viewAllTripsCustomer(customerId);
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry! Trip not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
	}
	
	//CalculateBill
	@GetMapping("/calculateBill")
	public ResponseEntity<Float> calculateBill(
			@PathVariable("customerId")Integer customerId){
		Float rtnValue=tripBookingService.calculateBill(customerId);
		if(rtnValue==null) {
			return new ResponseEntity("Sorry! Driver not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Float>(rtnValue, HttpStatus.OK);
	}
}