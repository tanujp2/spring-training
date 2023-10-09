package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

	private Coach coach;

	@Autowired
//	when you set up a dependency injection using autowiring and using an interface as the
//	dependency then spring will search for the beans that implement the given interface
//	and if there are multiple beans that implement that interface, then spring will not be
//	able to decide which of the implementations is to be injected.
//	hence the application will fail to start
	
//	to solve the issue you have to tell spring specifically which implementation bean it should
//	use.
//	use @Qualifier to specify the bean to be injected
	
	public DemoRestController(Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
