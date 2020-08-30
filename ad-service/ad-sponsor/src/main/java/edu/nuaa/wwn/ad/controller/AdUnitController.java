package edu.nuaa.wwn.ad.controller;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.AdUnitService;
import edu.nuaa.wwn.ad.vo.AdUnitDistrictRequest;
import edu.nuaa.wwn.ad.vo.AdUnitDistrictResponse;
import edu.nuaa.wwn.ad.vo.AdUnitItRequest;
import edu.nuaa.wwn.ad.vo.AdUnitItResponse;
import edu.nuaa.wwn.ad.vo.AdUnitKeywordRequest;
import edu.nuaa.wwn.ad.vo.AdUnitKeywordResponse;
import edu.nuaa.wwn.ad.vo.AdUnitRequest;
import edu.nuaa.wwn.ad.vo.AdUnitResponse;
import edu.nuaa.wwn.ad.vo.CreativeUnitRequest;
import edu.nuaa.wwn.ad.vo.CreativeUnitResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 14:07
 */
@Slf4j
@RestController
public class AdUnitController {

    private final AdUnitService adUnitService;

    @Autowired
    public AdUnitController(AdUnitService adUnitService) {
        this.adUnitService = adUnitService;
    }

    @PostMapping("/create/unit")
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnit -> {}",
                 JSON.toJSONString(request));
        return adUnitService.createAdUnit(request);
    }

    @PostMapping("/create/unit/keyword")
    public AdUnitKeywordResponse createUnitKeyword(@RequestBody AdUnitKeywordRequest request) throws AdException {
        log.info("ad-sponsor: createUnitKeyword -> {}",
                 JSON.toJSONString(request));
        return adUnitService.createAdUnitKeyword(request);
    }

    @PostMapping("/create/unit/it")
    public AdUnitItResponse createUnitIt(@RequestBody AdUnitItRequest request) throws AdException {
        log.info("ad-sponsor: createUnitKeyword -> {}",
                 JSON.toJSONString(request));
        return adUnitService.createAdUnitIt(request);
    }

    @PostMapping("/create/unit/district")
    public AdUnitDistrictResponse createUnitDistrict(@RequestBody AdUnitDistrictRequest request) throws AdException {
        log.info("ad-sponsor: createUnitDistrict -> {}",
                 JSON.toJSONString(request));
        return adUnitService.createAdUnitDistrict(request);
    }

    @PostMapping("/create/creativeUnit")
    public CreativeUnitResponse createCreativeUnit(@RequestBody CreativeUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnitDistrict -> {}",
                 JSON.toJSONString(request));
        return adUnitService.createCreativeUnit(request);
    }
}
