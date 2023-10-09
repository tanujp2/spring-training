package live.tanujdevops.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import live.tanujdevops.common.Coach;

@RestController
public class DemoRestController {

	private Coach coach;

//	@Qualifier solves the issue of multiple bean for a given interface by injecting a specific
//	bean by using name.

//	another approach to solve the issue uses @Primary annotation
//	@Primary annotation says which of the beans is a primary bean among multiple implementation
//	so, spring will automatically use @Primary as dependency when @Qualifier is not used

//	there can be only one @Primary, if @Primary is used on multiple implementations then again
//	you have a problem
	
//	which one to use: @Qualifier or @Primary
//	@Qualifier is preferable
	
//	when both @Qualifier and @Primary is present, the @Qualifier takes precedence

	@Autowired
	public DemoRestController(Coach coach) {
		this.coach = coach;
	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return coach.getDailyWorkout();
	}
}
