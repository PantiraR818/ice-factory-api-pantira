package nvc.it.icefactorypantira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class IcefactoryPantiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcefactoryPantiraApplication.class, args);
	}

}
