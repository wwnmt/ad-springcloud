package edu.nuaa.wwn.ad.service.impl;

import edu.nuaa.wwn.ad.constant.CommonStatus;
import edu.nuaa.wwn.ad.constant.Constants;
import edu.nuaa.wwn.ad.dao.PlanPOMapper;
import edu.nuaa.wwn.ad.dao.UserPOMapper;
import edu.nuaa.wwn.ad.entity.PlanPO;
import edu.nuaa.wwn.ad.entity.UserPO;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.AdPlanService;
import edu.nuaa.wwn.ad.utils.CommonUtils;
import edu.nuaa.wwn.ad.vo.AdPlanGetRequest;
import edu.nuaa.wwn.ad.vo.AdPlanRequest;
import edu.nuaa.wwn.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 9:34
 */
@Service
public class AdPlanServiceImpl implements AdPlanService {

    private final UserPOMapper userPOMapper;
    private final PlanPOMapper planPOMapper;

    @Autowired
    public AdPlanServiceImpl(UserPOMapper userPOMapper, PlanPOMapper planPOMapper) {
        this.userPOMapper = userPOMapper;
        this.planPOMapper = planPOMapper;
    }

    @Override
    @Transactional
    public AdPlanResponse createAdPLan(AdPlanRequest request) throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        UserPO user = userPOMapper.selectByPrimaryKey(request.getUserId());
        if (user == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        PlanPO oldPlan = planPOMapper.findByUserIdAndPlanName(request.getUserId(), request.getPlanName());
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_PLAN_NAME_ERROR);
        }

        PlanPO planPO = new PlanPO();
        planPO.setUserId(request.getUserId());
        planPO.setPlanStatus(request.getPlanStatus());
        planPO.setCreateTime(new Date());
        planPO.setUpdateTime(planPO.getCreateTime());
        planPO.setStartDate(CommonUtils.String2Date(request.getStartDate()));
        planPO.setEndDate(CommonUtils.String2Date(request.getEndDate()));
        planPO.setPlanName(request.getPlanName());
        planPOMapper.insert(planPO);
        return new AdPlanResponse(planPO.getId(), planPO.getPlanName());
    }

    @Override
    @Transactional
    public List<PlanPO> getAdPlanByIds(AdPlanGetRequest request) throws AdException {

        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<PlanPO> planList = planPOMapper.findAllByIdsAndUserId(request.getUserId(), request.getIds());
        if (planList == null || planList.size() == 0) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        return planList;
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {

        if (!request.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        PlanPO oldPlan = planPOMapper.findByUserIdAndId(request.getUserId(), request.getId());
        if (oldPlan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        if (request.getPlanName() != null) {
            oldPlan.setPlanName(request.getPlanName());
        }
        if (request.getStartDate() != null) {
            oldPlan.setStartDate(CommonUtils.String2Date(request.getStartDate()));
        }
        if (request.getEndDate() != null) {
            oldPlan.setEndDate(CommonUtils.String2Date(request.getEndDate()));
        }
        oldPlan.setUpdateTime(new Date());
        planPOMapper.updateByPrimaryKeySelective(oldPlan);
        return new AdPlanResponse(oldPlan.getId(), oldPlan.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {

        if (!request.deleteValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        PlanPO oldPlan = planPOMapper.findByUserIdAndId(request.getUserId(), request.getId());
        if (oldPlan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }
        oldPlan.setPlanStatus((byte) CommonStatus.INVALID.getStatus());
        oldPlan.setUpdateTime(new Date());
        planPOMapper.updateByPrimaryKeySelective(oldPlan);
    }
}
