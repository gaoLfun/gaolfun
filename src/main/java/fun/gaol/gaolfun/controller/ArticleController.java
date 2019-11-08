package fun.gaol.gaolfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
    @RequestMapping("/Article")
    public String article() {
        return "Article";
    }
}
