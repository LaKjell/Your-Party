package com.wwi318.YourParty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Repository.LocationRepository;

@SpringBootApplication
public class YourPartyApplication {

	private static final Logger log = LoggerFactory.getLogger(YourPartyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(YourPartyApplication.class, args);
	}

}
