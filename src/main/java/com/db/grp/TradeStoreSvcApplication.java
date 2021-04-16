package com.db.grp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeStoreSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeStoreSvcApplication.class, args);
	}

}
