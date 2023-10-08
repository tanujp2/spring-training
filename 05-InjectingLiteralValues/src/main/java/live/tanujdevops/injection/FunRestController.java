package live.tanujdevops.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //    inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //    expose endpoint "teaminfo"
    @GetMapping("teaminfo")
    private String getTeamInfo() {
        return "<p>Coach : " + coachName + "</p><p>Team : " + teamName + "</p>";
    }
}
