package live.tanujdevops.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("CricketCoach.CricketCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

}
