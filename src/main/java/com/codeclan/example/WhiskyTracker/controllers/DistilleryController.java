package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

	@Autowired
	DistilleryRepository distilleryRepository;

	@GetMapping("/region/{region}")
	public List<Distillery> getDistilleriesByRegion(@PathVariable String region) {
		return distilleryRepository.getDistilleryByRegion(region);
	};

	@GetMapping("/{distillery}/whiskies/aged/{age}")
		public List<Whisky> getWhiskiesWithAge(@PathVariable String distillery, @PathVariable Integer age) {
		return distilleryRepository.findWhiskiesFromDistilleriesWithAge(distillery,age);
	}

}
