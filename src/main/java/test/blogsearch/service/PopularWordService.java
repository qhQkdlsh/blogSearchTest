package test.blogsearch.service;

import test.blogsearch.domain.KeywordInfoEntity;

import java.util.List;

public interface PopularWordService {
    /**
     * lee_sm 230305
     * 인기 검색어 리턴(디코딩)
     * @return
     */
    List<KeywordInfoEntity> getPopularWordList();
}
