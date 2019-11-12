package fun.gaol.gaolfun.action.about.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutAction {
    @RequestMapping("/About")
    public String article() {
        return "About";
    }
}
