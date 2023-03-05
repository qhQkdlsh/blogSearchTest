package test.blogsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogMainController {
    @RequestMapping("/")
    public String blogMainPage(Model model){
        return "main";
    }
}
