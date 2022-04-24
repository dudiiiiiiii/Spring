package pl.cansoft.spring3.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cansoft.spring3.models.Product;
import pl.cansoft.spring3.models.ProductCategory;

@Controller
public class ProductController {

    private Long nextId;
    private List<Product> products = new ArrayList<>();

    public ProductController() {
        var now = LocalDateTime.now();
        products.add(new Product(1L, "iPhone X", "Treść 1", 100, ProductCategory.PHONES, now, null));
        products.add(new Product(2L, "MacBook Air", "Treść 2", 110, ProductCategory.COMPUTERS, now.minusMonths(2), null));
        products.add(new Product(3L, "iMac", "Treść 3", 90, ProductCategory.COMPUTERS, now.minusMonths(2), null));
        products.add(new Product(4L, "Apple Watch", "Treść 4", 200, ProductCategory.CLOCK, now.minusMonths(3), null));
        products.add(new Product(5L, "iPhone 13", "Treść 5", 400, ProductCategory.PHONES, now.minusMonths(3).minusYears(1), null));
        nextId = 6L;
    }

    @GetMapping("products")
    public String products(
        @RequestParam(required = false, name = "pf") Integer priceFrom,
        @RequestParam(required = false, name = "pt") Integer priceTo,
        @RequestParam(required = false, name = "n") String name,
        @RequestParam(required = false, name = "c") ProductCategory category,
        Model model) {
        var filtered = products.stream()
            .filter(product -> name == null || product.getName().contains(name))
            .filter(product -> category == null || product.getCategory().equals(category))
            .filter(product -> {
                if (product.getPrice() == null) {
                    return false;
                }
                var priceFromTemp = priceFrom;
                if (priceFromTemp == null) {
                    priceFromTemp = 0;
                }
                var priceToTemp = priceTo;
                if (priceToTemp == null) {
                    priceToTemp = Integer.MAX_VALUE;
                }
                return product.getPrice() >= priceFromTemp && product.getPrice() <= priceToTemp;
            })
            .toList();
        model.addAttribute("categories",  ProductCategory.values());
        model.addAttribute("items", filtered);
        model.addAttribute("priceFrom", priceFrom);
        model.addAttribute("priceTo", priceTo);
        model.addAttribute("name", name);
        model.addAttribute("category", category);
        return "products";
    }

    @GetMapping("add-product")
    public String addProductForm(Model model) {
        model.addAttribute("categories",  ProductCategory.values());
        return "admin/addProduct";
    }

    @PostMapping("add-product")
    public String addProduct(Product product) {
        product.setId(nextId);
        product.setCreatedAt(LocalDateTime.now());
        products.add(product);
        nextId++;
        return "redirect:/products";
    }
}
