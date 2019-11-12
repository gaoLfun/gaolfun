package fun.gaol.gaolfun.action.moments.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MomentsAction {
    @RequestMapping("/Moments")
    public String article() {
        return "Moments";
    }
}
