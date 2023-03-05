package test.blogsearch.service;

import test.blogsearch.dto.SearchDTO;

public interface KeywordService {

    /**
     * lee_sm 230305
     * 검색어 조회수 증가
     * @param sc
     */
    void keywordCountUpdate(SearchDTO sc);
}
