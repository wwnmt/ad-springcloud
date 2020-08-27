package edu.nuaa.wwn.ad.controller;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.CreativeService;
import edu.nuaa.wwn.ad.vo.CreativeRequest;
import edu.nuaa.wwn.ad.vo.CreativeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 14:13
 */
@Slf4j
@RestController
public class CreativeController {

    private final CreativeService creativeService;

    @Autowired
    public CreativeController(CreativeService creativeService) {
        this.creativeService = creativeService;
    }

    public CreativeResponse createCreative(@RequestBody CreativeRequest request) throws AdException {
        log.info("ad-sponsor: createCreative: -> {}",
                 JSON.toJSONString(request));
        return creativeService.createAdCreative(request);
    }
}
