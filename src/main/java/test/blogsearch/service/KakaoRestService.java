package test.blogsearch.service;

import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

public interface KakaoRestService {
    /**
     * lee_sm 230305
     * 카카오 API 호출
     * @param searchDto
     * @return
     */
    BlogDTO getData(SearchDTO searchDTO);
}
