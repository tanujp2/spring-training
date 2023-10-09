package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {
	private Coach coach;

	@Autowired
//	since you are using setter method to inject the dependency you call this mechanism as setter injection
//	public void setCoach(Coach coach) {
//		this.coach = coach;
//	

	public void coachInjector(Coach coach) {
		this.coach = coach;
	}

//	in fact, spring can use any arbitrary method for dependency injection provided it is annotated with
//	@Autowired

//	constructor injection is the recommended approach, use it when the dependency has to be provided
//	from your end

//	setter injection is used when the dependency setting is not that much important and a default value
//	will do the work

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
