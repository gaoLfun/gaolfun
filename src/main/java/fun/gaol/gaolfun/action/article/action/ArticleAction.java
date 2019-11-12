package fun.gaol.gaolfun.action.article.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleAction {
    @RequestMapping("/Article")
    public String article() {
        return "Article";
    }
}
