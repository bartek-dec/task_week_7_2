package com.example.demo.api;

import com.example.demo.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@RestController
public class NewsApi {

    @Value("${base_url}")
    private String baseUrl;
    @Value("${limit_param}")
    private String limitParam;
    @Value("${limit_value}")
    private String limitValue;

    private RestTemplate restTemplate;

    @Autowired
    public NewsApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<News> getNews() {
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam(limitParam, limitValue);

        News[] results = restTemplate.getForObject(url.toUriString(), News[].class);
        return Arrays.asList(results);
    }
}
