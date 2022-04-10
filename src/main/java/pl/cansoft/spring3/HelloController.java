package pl.cansoft.spring3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HelloController {

    Map<String, String> blogMap = Map.of(
        "czerwiec", "Jakiś artykuł z miesiąca Czerwiec",
        "lipiec", "Jakiś artykuł z miesiąca Lipiec",
        "sierpień", "Jakiś artykuł z miesiąca Sierpień"
    );

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

    @GetMapping("blog")
    public String blog(@RequestParam(required = false) String m, Model model) {
        if (m != null) {
            // sprawdzam null ponieważ required = false (m może być nullem)
            // jeżeli required = true - sprawdzanie nie ma sensu (m nigdy nie będzie nullem)
            var value = blogMap.get(m);
            model.addAttribute("content", value);
        }
        model.addAttribute("month", m);
        return "blog/blog";
    }

    @GetMapping("blog/{month}")
    public String blogPath(@PathVariable String month, Model model) {
        var value = blogMap.get(month);
        model.addAttribute("content", value);
        model.addAttribute("month", month);
        return "blog/blog";
    }
}
