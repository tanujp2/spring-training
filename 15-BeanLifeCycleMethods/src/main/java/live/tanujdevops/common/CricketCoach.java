package live.tanujdevops.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("CricketCoach.CricketCoach()");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@PostConstruct
	public void myInt() {
		System.out.println("CricketCoach.myInt()");
	}

	@PreDestroy
	public void myDestroy() {
		System.out.println("CricketCoach.myDestroy()");
	}

}
