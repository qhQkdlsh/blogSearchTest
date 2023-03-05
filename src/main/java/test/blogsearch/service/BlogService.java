package test.blogsearch.service;

import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

public interface BlogService {

    /**
     * lee_sm 230305
     * 카카오 및 네이버 API 호출
     * @param sc
     * @return
     */
    BlogDTO getBlogList(SearchDTO sc);
}
