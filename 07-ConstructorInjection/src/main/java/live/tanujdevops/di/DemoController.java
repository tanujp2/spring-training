package live.tanujdevops.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private Coach coach;

	@Autowired
//	if we have only one constructor in the class, then @Autowired is optional
	public DemoController(Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDalyWorkout() {
		return coach.getDailyWorkout();
	}
}
