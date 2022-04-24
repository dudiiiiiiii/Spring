package pl.cansoft.spring3.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cansoft.spring3.models.Article;
import pl.cansoft.spring3.models.ArticleCategory;

@Controller
public class ArticleController {

    private Long nextId;
    private List<Article> articles = new ArrayList<>();

    public ArticleController() {
        var now = LocalDateTime.now();
        articles.add(new Article(1L, "Tytuł 1", "Treść 1", ArticleCategory.GUIDE, now, null));
        articles.add(new Article(2L, "Tytuł 2", "Treść 2", ArticleCategory.TECHNICAL, now.minusMonths(2), null));
        articles.add(new Article(3L, "Tytuł 3", "Treść 3", ArticleCategory.GUIDE, now.minusMonths(2), null));
        articles.add(new Article(4L, "Tytuł 4", "Treść 4", ArticleCategory.TECHNICAL, now.minusMonths(3), null));
        articles.add(new Article(5L, "Tytuł 5", "Treść 5", ArticleCategory.OTHER, now.minusMonths(3).minusYears(1), null));
        nextId = 6L;
    }

    @GetMapping("blog")
    public String blog(@RequestParam(required = false, name = "m") Integer month,
                       @RequestParam(required = false, name = "y") Integer year,
                       @RequestParam(required = false, name = "c") ArticleCategory category,
                       Model model) {
        var filtered = articles.stream()
            .filter(article -> category == null || article.getCategory().equals(category))
            .filter(article -> month == null || article.getCreatedAt().getMonthValue() == month)
            .filter(article -> year == null || article.getCreatedAt().getYear() == year)
            .toList();
        model.addAttribute("categories",  ArticleCategory.values());
        model.addAttribute("category",  category);
        model.addAttribute("items", filtered);
        model.addAttribute("month", month);
        model.addAttribute("year", year);
        return "blog/blog";
    }

    @GetMapping("add-article")
    public String addArticleForm(Model model) {
        model.addAttribute("categories",  ArticleCategory.values());
        return "admin/addArticle";
    }

    @PostMapping("add-article")
    public String addArticle(Article article) {
        article.setId(nextId);
        article.setCreatedAt(LocalDateTime.now());
        articles.add(article);
        nextId++;
        return "redirect:/blog";
    }
}
