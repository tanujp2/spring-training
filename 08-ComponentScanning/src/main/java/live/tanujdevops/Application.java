package live.tanujdevops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Tell spring to scan additional packages for component
//use scanBasePackages argument of @SpringBootApplication
//do list the package where @SpringBootApplication resides also

@SpringBootApplication(scanBasePackages = { "live.tanujdevops", "util" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
