package es.fpdual.eadmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EadminApplication {

	private static final Logger logger = LoggerFactory.getLogger(EadminApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EadminApplication.class, args);
		
		logger.info("Esto es una prueba");
	}
}
