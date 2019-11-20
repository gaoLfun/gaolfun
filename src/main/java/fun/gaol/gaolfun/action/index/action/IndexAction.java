package fun.gaol.gaolfun.action.index.action;

import fun.gaol.gaolfun.action.index.bo.IndexManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class IndexAction {
    @Autowired
    private IndexManager indexManager;
    @RequestMapping("/Index")
    public String home(Model model) {
        List<Map<String, Object>> list_article = indexManager.getArticle();
        model.addAttribute("list_article",list_article);
        return "Index";
    }
}
