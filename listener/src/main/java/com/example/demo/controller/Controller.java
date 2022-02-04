package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
public class Controller {

	private boolean boolState = true;
	
	@GetMapping("/getState")
	public boolean getState() {
		System.out.println("State read -> "+boolState);
		return boolState;
	}
	
	@GetMapping("/setState/{state}")
	public void setState(@PathVariable boolean state) {
		boolState = state;
		System.out.println("State changed to "+boolState);
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
}
