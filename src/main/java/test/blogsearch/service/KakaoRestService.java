package test.blogsearch.service;

import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

public interface KakaoRestService {
    BlogDTO getData(SearchDTO searchDTO);
}