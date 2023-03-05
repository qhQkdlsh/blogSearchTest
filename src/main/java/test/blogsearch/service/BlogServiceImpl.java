package test.blogsearch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

@Service
public class BlogServiceImpl implements BlogService {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private KakaoRestService kakaoRestService;
    @Autowired
    private NaverRestService naverRestService;

    @Override
    public BlogDTO getBlogList(SearchDTO sc){

        try{
            return kakaoRestService.getData(sc);
        }catch (Exception e){
            log.error("KAKAO API 통신 에러");
            log.error(e.toString());

            try{
                return naverRestService.getData(sc);
            }catch (Exception e2){
                log.error("Naver API 통신 에러");
                log.error(e2.toString());
            }
        }
        return new BlogDTO();
    }
}
