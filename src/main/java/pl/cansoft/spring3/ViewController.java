package pl.cansoft.spring3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cansoft.spring3.models.Article;

@Controller
public class ViewController {

    private List<Article> articles = new ArrayList<>();

    public ViewController() {
        var now = LocalDateTime.now();
        articles.add(new Article(1L, "Tytuł 1", "Treść 1", now, null));
        articles.add(new Article(2L, "Tytuł 2", "Treść 2", now.minusMonths(2), null));
        articles.add(new Article(3L, "Tytuł 3", "Treść 3", now.minusMonths(2), null));
        articles.add(new Article(4L, "Tytuł 4", "Treść 4", now.minusMonths(3), null));
        articles.add(new Article(5L, "Tytuł 5", "Treść 5", now.minusMonths(3).minusYears(1), null));
    }

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

    @GetMapping("blog")
    public String blog(@RequestParam(required = false) Integer m,
                       @RequestParam(required = false) Integer y,
                       Model model) {
        var filtered = articles.stream()
            .filter(article -> m == null || article.getCreatedAt().getMonthValue() == m)
            .filter(article -> y == null || article.getCreatedAt().getYear() == y)
            .toList();
        model.addAttribute("items", filtered);
        return "blog/blog";
    }
}
