package pl.cansoft.spring3.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cansoft.spring3.models.Article;

@Controller
public class ArticleController {

    private List<Article> articles = new ArrayList<>();

    public ArticleController() {
        var now = LocalDateTime.now();
        articles.add(new Article(1L, "Tytuł 1", "Treść 1", now, null));
        articles.add(new Article(2L, "Tytuł 2", "Treść 2", now.minusMonths(2), null));
        articles.add(new Article(3L, "Tytuł 3", "Treść 3", now.minusMonths(2), null));
        articles.add(new Article(4L, "Tytuł 4", "Treść 4", now.minusMonths(3), null));
        articles.add(new Article(5L, "Tytuł 5", "Treść 5", now.minusMonths(3).minusYears(1), null));
    }

    @GetMapping("blog")
    public String blog(@RequestParam(required = false, name = "m") Integer month,
                       @RequestParam(required = false, name = "y") Integer year,
                       Model model) {
        var filtered = articles.stream()
            .filter(article -> month == null || article.getCreatedAt().getMonthValue() == month)
            .filter(article -> year == null || article.getCreatedAt().getYear() == year)
            .toList();
        model.addAttribute("items", filtered);
        return "blog/blog";
    }
}
