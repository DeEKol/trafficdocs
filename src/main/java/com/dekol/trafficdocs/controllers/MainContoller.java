package com.dekol.trafficdocs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dekol.trafficdocs.repository.TripRepository;

@Controller
@RequestMapping("/")
public class MainContoller {
	
	private final TripRepository tripRepository;
	
	public MainContoller(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}
	
	@GetMapping
	public String main(Model model) {		
		model.addAttribute("frontendData", tripRepository.findAll());
		
		return "index";
	}
}
