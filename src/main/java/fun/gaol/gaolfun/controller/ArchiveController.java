package fun.gaol.gaolfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchiveController {
    @RequestMapping("/Archive")
    public String article() {
        return "Archive";
    }
}
