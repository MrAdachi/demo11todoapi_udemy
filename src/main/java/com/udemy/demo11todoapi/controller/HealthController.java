package com.udemy.demo11todoapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi {

	@Override
	public ResponseEntity<Void> healthGet() {
		return ResponseEntity.ok().build();
	}
}
