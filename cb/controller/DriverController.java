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
import com.cap.cb.service.DriverService;


@RestController
@RequestMapping("/api/c4")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	//insertDriver
	@PostMapping("/saveDriver")
	public ResponseEntity<Driver> insertDriver(
			@RequestBody Driver driver){
		Driver drive = driverService.insertDriver(driver);
		if(drive== null)
		{
			return new ResponseEntity("Sorry! Driver not available!",
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Driver>(drive, HttpStatus.OK);
	}
	
	//updateDriver
	@PutMapping("/putDriver")
	public ResponseEntity<Driver> updateDriver(
			@RequestBody Driver driver){
		Driver drive= driverService.updateDriver(driver);
		if(drive== null)
		{
			return new ResponseEntity("Sorry! Driver not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Driver>(drive, HttpStatus.OK);
	}
	
	//deleteDriver
	@DeleteMapping("/delDriver/{driverId}")
	public ResponseEntity<Driver> deleteDriver(
			@PathVariable("driverId")Integer driverId){
		Driver drive= driverService.deleteDriver(driverId);
		if(drive==null) {
			return new ResponseEntity("Sorry! driverId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Driver>(drive, HttpStatus.OK);
	}
	
	//viewBestDriver
	@GetMapping("/getAllDrivers")
	public ResponseEntity<List<Driver>> getAll(){
		List<Driver> drivers= driverService.viewBestDrivers();
		if(drivers.isEmpty()) {
			return new ResponseEntity("Sorry! Driver not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Driver>>(drivers, HttpStatus.OK);
	}
	
	//viewDriver
	@GetMapping("/getDriver")
	public ResponseEntity<Driver> get(
			@PathVariable("driverId")Integer driverId){
		Driver drive=driverService.viewDriver(driverId);
		if(drive== null) {
			return new ResponseEntity("Sorry! Driver not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Driver>(drive, HttpStatus.OK);
	}
}