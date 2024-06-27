package com.udemy.demo11todoapi.service.sample;

import org.springframework.stereotype.Service;

import com.udemy.demo11todoapi.repository.sample.SampleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {
	
	private final SampleRepository repository;

	public SampleEntity find() {
		var record = repository.select();
		return new SampleEntity(record.getContent());
	}
}
