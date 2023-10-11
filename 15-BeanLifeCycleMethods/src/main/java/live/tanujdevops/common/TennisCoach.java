package live.tanujdevops.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public TennisCoach() {
		System.out.println("TennisCoach.TennisCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
