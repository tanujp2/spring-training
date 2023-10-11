package live.tanujdevops.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	public BaseballCoach() {
		System.out.println("BaseballCoach.BaseballCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes in batting practice";
	}

}
