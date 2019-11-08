package fun.gaol.gaolfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String home(String name) {
        System.out.println(11111111);
        return "index";
    }
}
