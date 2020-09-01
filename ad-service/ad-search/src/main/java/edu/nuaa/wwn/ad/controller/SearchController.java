package edu.nuaa.wwn.ad.controller;

import edu.nuaa.wwn.ad.search.ISearch;
import edu.nuaa.wwn.ad.search.vo.SearchRequest;
import edu.nuaa.wwn.ad.search.vo.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 16:33
 */
@Slf4j
@RestController
public class SearchController {

    private final RestTemplate restTemplate;

    private final ISearch search;

    @Autowired
    public SearchController(RestTemplate restTemplate, ISearch search) {
        this.restTemplate = restTemplate;
        this.search = search;
    }

    @PostMapping("/fetchAds")
    public SearchResponse fetchAds(@RequestBody SearchRequest request) {
        log.info("ad-search: fetchAds -> {}", request);
        return search.fetchAds(request);
    }
}
