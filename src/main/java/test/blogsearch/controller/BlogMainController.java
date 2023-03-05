package test.blogsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogMainController {

    /**
     * lee_sm 230305
     * 메인 호출
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String blogMainPage(Model model){
        return "main";
    }
}
