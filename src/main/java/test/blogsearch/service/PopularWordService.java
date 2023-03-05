package test.blogsearch.service;

import test.blogsearch.domain.KeywordInfoEntity;

import java.util.List;

public interface PopularWordService {
    List<KeywordInfoEntity> getPopularWordList();
}
