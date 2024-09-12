package org.projecthusky.handson;

import org.projecthusky.handson.dis.DispenseBuisnessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class HuskyHandsonEmedApplication implements ApplicationRunner {
	
	@Autowired
	private DispenseBuisnessLogic dispenseBuisnessLogic;

	public static void main(String[] args) {
		SpringApplication.run(HuskyHandsonEmedApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Hello Husky Hands-on Emed!");

		if (args.containsOption("createdis")) {
			log.info("create EMED DISPENSE DOCUMENT");
			dispenseBuisnessLogic.createDispenseDocument();
		} else if (args.containsOption("readdis")) {
			log.info("read and validate EMED DISPENSE DOCUMENT");

		}

	}

}
