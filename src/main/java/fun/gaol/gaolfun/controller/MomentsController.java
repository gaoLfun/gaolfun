package fun.gaol.gaolfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MomentsController {
    @RequestMapping("/Moments")
    public String article() {
        return "Moments";
    }
}
