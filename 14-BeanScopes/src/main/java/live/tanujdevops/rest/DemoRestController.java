package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

	private Coach coach;
	private Coach anotherCoach;

	@Autowired
	public DemoRestController(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach) {
		System.out.println("DemoRestController.DemoRestController(Coach)");
		this.coach = coach;
		this.anotherCoach = anotherCoach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}

	@GetMapping("/check")
	public String check() {
		return "coach == anotherCoach is " + (coach == anotherCoach);
	}
}
