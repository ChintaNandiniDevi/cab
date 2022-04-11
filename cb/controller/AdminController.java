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

import com.cap.cb.entities.Admin;
import com.cap.cb.entities.TripBooking;
import com.cap.cb.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/insertAdmin")
	public ResponseEntity<Admin> insertAdmin(
			@RequestBody Admin admin)
	{
		Admin ad= adminService.insertAdmin(admin);
		if(ad==null)
		{
			return new ResponseEntity("sorry! admin is not inserted!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}
	
	@PutMapping("/putAdmin")
	public ResponseEntity<Admin> updateAdmin(
			@RequestBody Admin admin){
		Admin ad= adminService.updateAdmin(admin);
		if(ad==null)
		{
			return new ResponseEntity("Sorry! admin not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}
	
	@DeleteMapping("/delAdmin")
	public ResponseEntity<Admin> deleteAdmin(
			@RequestBody Admin admin){
		Admin ad = adminService.deleteAdmin(admin);
		if( ad==null) {
			return new ResponseEntity("Sorry! Admin not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}
	
	@GetMapping("/getAllTrips")
	public ResponseEntity<List<TripBooking>> getAll(
			@PathVariable("customerId")Integer customerId){
		List<TripBooking> trips= adminService.getAllTrips(customerId);
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry! customerId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
	}
	
	@GetMapping("/getTripsCabWise")
	public ResponseEntity<List<TripBooking>> getTripsCabWise(
			@RequestBody Admin admin){
		List<TripBooking> trips= adminService.getTripsCabWise();
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry! cabs not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
	}
	
	
	@GetMapping("/getTripsCustomerWise")
	public ResponseEntity<List<TripBooking>> getTripsCustomerWise(
			@RequestBody Admin admin){
		List<TripBooking> trips= adminService.getTripsCustomerWise();
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry! customers not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
	}
	
	@GetMapping("/getTripsDateWise")
	public ResponseEntity<List<TripBooking>> getTripsDateWise(
			@RequestBody Admin admin){
		List<TripBooking> trips= adminService.getTripsDateWise();
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry! trips not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<TripBooking>>(trips, HttpStatus.OK);
	}
}
