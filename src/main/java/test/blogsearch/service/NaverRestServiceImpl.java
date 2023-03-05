package test.blogsearch.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import test.blogsearch.dto.BlogDTO;
import test.blogsearch.dto.SearchDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NaverRestServiceImpl implements NaverRestService {

    @Value("${blogApi.naver.clientId}")
    private String naverClientId;
    @Value("${blogApi.naver.clientSecret}")
    private String naverClientSecret;
    @Value("${blogApi.naver.url}")
    private String naverBaseUrl;

    @Override
    public BlogDTO getData(SearchDTO searchDto){

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(naverBaseUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);

        WebClient webClient = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(naverBaseUrl)
                .defaultHeader("X-Naver-Client-Id",naverClientId)
                .defaultHeader("X-Naver-Client-Secret",naverClientSecret)
                .build();

        Map<String,Object> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", searchDto.getKeyword())
                        .queryParam("start", searchDto.getPage())
                        .queryParam("display", searchDto.getSize())
                        .queryParam("sort", (searchDto.getSort().equals("accuracy")?"sim":"date"))
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .map( m -> {
                    Map<String,Object> meta = new HashMap<String,Object>();
                    meta.put("total_count",m.getOrDefault("total",0));
                    m.put("meta",meta);
                    m.put("documents",  ( (List<HashMap<String,Object>>) m.get("items")).stream().map( i -> {
                            i.put("contents",i.getOrDefault("description",""));
                            i.put("url",i.getOrDefault("link",""));
                            i.put("blogname",i.getOrDefault("bloggername",""));
                            i.put("datetime",i.getOrDefault("postdate",""));
                            return i;
                        }).toList()
                    );

                    return m;
                })
                .block();

        return new BlogDTO(response);
    }
}
