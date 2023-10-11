package live.tanujdevops.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("CricketCoach.CricketCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

}
