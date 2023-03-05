package test.blogsearch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import test.blogsearch.dto.SearchDTO;

@Service
public class NaverRestServiceImpl implements NaverRestService {

    @Value("${blogApi.naver.clientId}")
    private String naverClientId;
    @Value("${blogApi.naver.clientSecret}")
    private String naverClientSecret;
    @Value("${blogApi.naver.url}")
    private String naverBaseUrl;

    @Override
    public String getData(SearchDTO searchDto){

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(naverBaseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(naverBaseUrl)
                .defaultHeader("X-Naver-Client-Id",naverClientId)
                .defaultHeader("X-Naver-Client-Secret",naverClientSecret)
                .build();

        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", searchDto.getKeyword())
                        .queryParam("start", searchDto.getPage())
                        .queryParam("display", searchDto.getSize())
                        .queryParam("sort", (searchDto.getSort().equals("accuracy")?"sim":"date"))
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
