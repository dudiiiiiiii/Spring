package pl.cansoft.spring3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping
    public String home() {
        return "home";
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
