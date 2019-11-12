package fun.gaol.gaolfun.action.archive.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchiveAction {
    @RequestMapping("/Archive")
    public String article() {
        return "Archive";
    }
}
