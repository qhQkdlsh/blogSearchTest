package test.blogsearch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

@Service
public class KakaoRestServiceImpl implements KakaoRestService {

    @Value("${blogApi.kakao.key}")
    private String kakaoApiKey;
    @Value("${blogApi.kakao.url}")
    private String kakaoBaseUrl;

    @Override
    public BlogDTO getData(SearchDTO searchDto){

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(kakaoBaseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(kakaoBaseUrl)
                .defaultHeader("Authorization",kakaoApiKey)
                .build();

        BlogDTO blogDTO = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", searchDto.getKeyword())
                        .queryParam("sort", searchDto.getSort())
                        .queryParam("page", searchDto.getPage())
                        .queryParam("size", searchDto.getSize())
                        .build())
                .retrieve()
                .bodyToMono(BlogDTO.class)
                .block();

        return blogDTO;
    }
}
