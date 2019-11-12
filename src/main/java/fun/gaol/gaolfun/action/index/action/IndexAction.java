package fun.gaol.gaolfun.action.index.action;

import fun.gaol.gaolfun.action.index.bo.IndexManager;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class IndexAction {
    @Autowired
    private IndexManager indexManager;
    @RequestMapping("/Index")
    public String home(HttpServletRequest request) {
        List<Map<String, Object>> list = indexManager.getArticle();
        request.setAttribute("list",list);
        return "Index";
    }
}
