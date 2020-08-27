package edu.nuaa.wwn.ad.controller;

import com.alibaba.fastjson.JSON;
import edu.nuaa.wwn.ad.entity.PlanPO;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.AdPlanService;
import edu.nuaa.wwn.ad.vo.AdPlanGetRequest;
import edu.nuaa.wwn.ad.vo.AdPlanRequest;
import edu.nuaa.wwn.ad.vo.AdPlanResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 11:59
 */
@Slf4j
@RestController
public class AdPlanController {
    private final AdPlanService adPlanService;

    @Autowired
    public AdPlanController(AdPlanService adPlanService) {
        this.adPlanService = adPlanService;
    }

    @PostMapping("/create/plan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}",
                 JSON.toJSONString(request));
        return adPlanService.createAdPLan(request);
    }

    @PostMapping("/list/plan")
    public List<PlanPO> listAdPlanByIds(@RequestBody AdPlanGetRequest request) throws AdException {
        log.info("ad-sponsor: listAdPlanByIds -> {}",
                 JSON.toJSONString(request));
        return adPlanService.getAdPlanByIds(request);
    }

    @PutMapping("/update/plan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}",
                 JSON.toJSONString(request));
        return adPlanService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/plan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}",
                 JSON.toJSONString(request));
        adPlanService.deleteAdPlan(request);
    }
}
