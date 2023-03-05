package test.blogsearch.service;

import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

public interface NaverRestService {

    /**
     * lee_sm 230305
     * 네이버 API 호출(WebClient)
     * @param searchDto
     * @return
     */
    BlogDTO getData(SearchDTO searchDto);
}
