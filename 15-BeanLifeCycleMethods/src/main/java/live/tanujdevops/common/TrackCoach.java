package live.tanujdevops.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	public TrackCoach() {
		System.out.println("TrackCoach.TrackCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k!";
	}

}
