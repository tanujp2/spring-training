package live.tanujdevops.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Bean("today")
//	@Bean is used with @Configuration class
//	it is useful in cases where we want to use predefined classes as beans
//	because we cannot annotate such classes with @Component, hence we have to use
//	@Bean to make them a bean or component
	public LocalDate getLocalDate() {
		return LocalDate.now();
	}
}
