package fun.gaol.gaolfun.action.resources.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourcesAction {
    @RequestMapping("/Resources")
    public String article() {
        return "Resources";
    }
}
