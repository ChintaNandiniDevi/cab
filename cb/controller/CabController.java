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

import com.cap.cb.entities.Cab;
import com.cap.cb.service.CabService;


@RestController
@RequestMapping("/api/c2")
public class CabController {

	@Autowired
	private CabService cabService;
	
	@PostMapping("/insertCab")
	public ResponseEntity<Cab> insertCab(
			@RequestBody Cab cab)
	{
		Cab ca= cabService.insertCab(cab);
		if(ca==null)
		{
			return new ResponseEntity("sorry! cab is not inserted!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cab>(ca, HttpStatus.OK);
	}
	
	@PutMapping("/putCab")
	public ResponseEntity<Cab> updateCab(
			@RequestBody Cab cab){
		Cab ca= cabService.updateCab(cab);
		if(ca==null)
		{
			return new ResponseEntity("Sorry! cab not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cab>(ca, HttpStatus.OK);
	}
	
	@DeleteMapping("/delCab/{cabId}")
	public ResponseEntity<Cab> deleteCab(
			@PathVariable("cabId")Integer productId){
		Cab ca= cabService.deleteCab(productId);
		if(ca==null) {
			return new ResponseEntity("Sorry! cabId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cab>(ca, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewCabsOfType")
	public ResponseEntity<List<Cab>> viewCabsOfType(
			@PathVariable("carType")String carType){
		List<Cab> ca= cabService.viewCabsOfType(carType);
		if(ca.isEmpty()) {
			return new ResponseEntity("Sorry! carType not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Cab>>(ca, HttpStatus.OK);
	}
	
	@GetMapping("/countCabsOfType")
	public ResponseEntity<List<Cab>> countCabsOfType(
			@PathVariable("carType")String carType){
		List<Cab> ca= cabService.viewCabsOfType(carType);
		if(ca.isEmpty()) {
			return new ResponseEntity("Sorry! carType not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Cab>>(ca, HttpStatus.OK);
	}
	
	
}
