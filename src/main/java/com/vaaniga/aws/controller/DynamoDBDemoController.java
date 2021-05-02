package com.vaaniga.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaaniga.aws.model.DataSource;
import com.vaaniga.aws.repository.DataSourceRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demo")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class DynamoDBDemoController {

	@Autowired
	private DataSourceRepository dataSourceRepo;
	
	@GetMapping("/")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("/datasource/count")
	public Long dataSourceCount() {
		return dataSourceRepo.count();
	}
	
	@GetMapping("/datasource")
	public Iterable<DataSource> getDataSources() {
		return dataSourceRepo.findAll();
	}
	
	@GetMapping("/datasource/{dataSourceUrl}")
	public Iterable<DataSource> getDataSources(@RequestParam String dataSourceUrl) {
		return dataSourceRepo.findByDataSourceUrl(dataSourceUrl);
	}
	
	@PostMapping("/datasource")
	public DataSource saveDataSource(@RequestBody String dataSourceValue) {
		
		log.info(dataSourceValue);
		
		DataSource dataSource = new DataSource();
		dataSource.setDataSourceUrl(dataSourceValue);
		
		return dataSourceRepo.save(dataSource);
	}
}
