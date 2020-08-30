package edu.nuaa.wwn.ad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public SearchController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
