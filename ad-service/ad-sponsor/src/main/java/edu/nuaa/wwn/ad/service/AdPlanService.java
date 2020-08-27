package edu.nuaa.wwn.ad.service;

import edu.nuaa.wwn.ad.entity.PlanPO;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.vo.AdPlanGetRequest;
import edu.nuaa.wwn.ad.vo.AdPlanRequest;
import edu.nuaa.wwn.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 9:19
 */
public interface AdPlanService {
    /**
     * 创建推广计划
     */
    AdPlanResponse createAdPLan(AdPlanRequest request) throws AdException;

    /**
     * 获取推广计划
     */
    List<PlanPO> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;

}
