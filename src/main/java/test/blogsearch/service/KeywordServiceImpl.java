package test.blogsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.blogsearch.domain.KeywordInfoEntity;
import test.blogsearch.dto.SearchDTO;
import test.blogsearch.repository.KeywordRepository;

@Service
public class KeywordServiceImpl implements KeywordService {
    KeywordRepository keywordRepository;

    @Autowired
    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Transactional
    @Override
    public void keywordCountUpdate(SearchDTO sc){
        if(sc.getKeyword() == null || sc.getKeyword().equals("")) return;
        KeywordInfoEntity keyInfo = keywordRepository.findKeywordAndUpdate(sc.getKeyword());
        if(keyInfo == null){
            keyInfo = new KeywordInfoEntity();
            keyInfo.setKeyword(sc.getKeyword());
            keywordRepository.save(keyInfo);
        }else{
            keyInfo.setSearchCount(keyInfo.getSearchCount()+1);
        }
    }
}
