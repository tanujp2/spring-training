package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

//by default, spring scans for components in the directory in which the @SpringBootApplication
//resides in rescursive manner, that includes its children directories also.
//directories outside the package will not be scanned, hence even if there are some @Component
//classes in those directories, they will not become beans hence unavailable for the dependency
//injection
//
//to solve the issue, you have to tell spring to can packages outside of the @SpringBootApplication
//class's package also

@RestController
public class DemoRestController {
	private Coach coach;

	@Autowired
	public DemoRestController(Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
