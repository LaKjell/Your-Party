package com.wwi318.YourParty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.wwi318.YourParty.Configuration.FileStorageProperities;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperities.class })
public class YourPartyApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YourPartyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(YourPartyApplication.class, args);
	}

}
