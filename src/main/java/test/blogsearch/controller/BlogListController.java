package test.blogsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;
import test.blogsearch.service.BlogService;
import test.blogsearch.service.KeywordService;
import test.blogsearch.service.PopularWordService;

import java.net.URLDecoder;

@Controller
public class BlogListController {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private KeywordService keywordService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private PopularWordService popularWordService;

    /**
     * 블로그 리스트 호출 및 조회
     * @param search
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String blogListPage(SearchDTO search, Model model){
        keywordService.keywordCountUpdate(search);
        model.addAttribute("popularList",popularWordService.getPopularWordList());
        BlogDTO blog = blogService.getBlogList(search);
        model.addAttribute("blog",blog);
        model.addAttribute("keyword",URLDecoder.decode(search.getKeyword()));
        search.setPageSize(blog);
        model.addAttribute("search",search);
        return "list";
    }
}
