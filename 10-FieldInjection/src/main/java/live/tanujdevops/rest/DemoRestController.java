package live.tanujdevops.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

//	you can directly inject the dependency by using a field (even private field) with @Autowired
//	this is called as Field Injection
//	it was very popular earlier, but it is not the recommended approach of dependency injection
//	because it makes unit testing harder.
//	field injection uses reflections to inject the dependency.

	private Coach coach;

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
