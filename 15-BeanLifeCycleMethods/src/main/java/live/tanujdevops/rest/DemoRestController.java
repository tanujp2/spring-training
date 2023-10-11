package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

	private Coach coach;

	@Autowired
	public DemoRestController(@Qualifier("cricketCoach") Coach coach) {
		System.out.println("DemoRestController.DemoRestController(Coach)");
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}

	@GetMapping("/shutdown")
	public void shutdown() {
		Thread t = new Thread(() -> {
			System.out.println("The system will shutdown in 5 seconds");
		});
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}
}
