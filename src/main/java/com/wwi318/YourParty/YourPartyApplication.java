package com.wwi318.YourParty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Repository.LocationRepository;
import com.wwi318.YourParty.Repository.UserRepository;

@SpringBootApplication
public class YourPartyApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YourPartyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(YourPartyApplication.class, args);
	}

}
