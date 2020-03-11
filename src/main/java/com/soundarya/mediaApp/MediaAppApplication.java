package com.soundarya.mediaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("com.soundarya.mediaApp")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class MediaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaAppApplication.class, args);
	}

}
