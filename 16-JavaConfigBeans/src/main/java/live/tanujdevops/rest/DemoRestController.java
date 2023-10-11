package live.tanujdevops.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

	private Coach coach;
	private LocalDate today;

	@Autowired
	public DemoRestController(@Qualifier("cricketCoach") Coach coach) {
		System.out.println("DemoRestController.DemoRestController(Coach)");
		this.coach = coach;
	}

	@Autowired
	public void setToday(@Qualifier("today") LocalDate today) {
		this.today = today;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}

	@GetMapping("/gettoday")
	public String getToday() {
		return today.toString();
	}
}
