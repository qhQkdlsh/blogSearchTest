package test.blogsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blogsearch.domain.KeywordInfoEntity;
import test.blogsearch.repository.KeywordRepository;

import java.net.URLDecoder;
import java.util.List;

@Service
public class PopularWordServiceImpl implements PopularWordService {

    KeywordRepository keywordRepository;

    @Autowired
    public PopularWordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    /**
     * lee_sm 230305
     * 인기 검색어 리턴(디코딩)
     * @return
     */
    @Override
    public List<KeywordInfoEntity> getPopularWordList(){
        List<KeywordInfoEntity> keyw = keywordRepository.findTop10ByOrderBySearchCountDesc();
        keyw = keyw.stream().map( k -> {
            k.setKeyword(URLDecoder.decode(k.getKeyword()));
            return k;
        }).toList();
        return keyw;
    }
}
