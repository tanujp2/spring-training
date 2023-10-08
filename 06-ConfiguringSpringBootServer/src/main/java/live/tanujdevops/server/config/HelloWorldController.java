package live.tanujdevops.server.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String greet() {
        return "<h1>Hello, World!</h1>";
    }
}
