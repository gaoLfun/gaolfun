package fun.gaol.gaolfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourcesController {
    @RequestMapping("/Resources")
    public String article() {
        return "Resources";
    }
}
