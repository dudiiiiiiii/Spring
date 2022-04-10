package pl.cansoft.spring3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("about-us")
    public String aboutUs() {
        return "aboutUs";
    }
}
