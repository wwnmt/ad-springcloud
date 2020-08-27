package edu.nuaa.wwn.ad.service.impl;

import edu.nuaa.wwn.ad.constant.Constants;
import edu.nuaa.wwn.ad.dao.CreativePOMapper;
import edu.nuaa.wwn.ad.dao.CreativeUnitPOMapper;
import edu.nuaa.wwn.ad.dao.PlanPOMapper;
import edu.nuaa.wwn.ad.dao.UnitDistrictPOMapper;
import edu.nuaa.wwn.ad.dao.UnitItPOMapper;
import edu.nuaa.wwn.ad.dao.UnitKeywordPOMapper;
import edu.nuaa.wwn.ad.dao.UnitPOMapper;
import edu.nuaa.wwn.ad.entity.CreativeUnitPO;
import edu.nuaa.wwn.ad.entity.PlanPO;
import edu.nuaa.wwn.ad.entity.UnitDistrictPO;
import edu.nuaa.wwn.ad.entity.UnitItPO;
import edu.nuaa.wwn.ad.entity.UnitKeywordPO;
import edu.nuaa.wwn.ad.entity.UnitPO;
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
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 10:23
 */
@Service
public class AdUnitServiceImpl implements AdUnitService {

    private final UnitPOMapper unitPOMapper;
    private final PlanPOMapper planPOMapper;
    private final UnitItPOMapper unitItPOMapper;
    private final UnitKeywordPOMapper unitKeywordPOMapper;
    private final UnitDistrictPOMapper unitDistrictPOMapper;
    private final CreativePOMapper creativePOMapper;
    private final CreativeUnitPOMapper creativeUnitPOMapper;

    @Autowired
    public AdUnitServiceImpl(UnitPOMapper unitPOMapper,
                             PlanPOMapper planPOMapper,
                             UnitItPOMapper unitItPOMapper,
                             UnitDistrictPOMapper unitDistrictPOMapper,
                             UnitKeywordPOMapper unitKeywordPOMapper,
                             CreativePOMapper creativePOMapper,
                             CreativeUnitPOMapper creativeUnitPOMapper) {
        this.unitPOMapper = unitPOMapper;
        this.planPOMapper = planPOMapper;
        this.unitItPOMapper = unitItPOMapper;
        this.unitDistrictPOMapper = unitDistrictPOMapper;
        this.unitKeywordPOMapper = unitKeywordPOMapper;
        this.creativePOMapper = creativePOMapper;
        this.creativeUnitPOMapper = creativeUnitPOMapper;
    }

    @Override
    public AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {

        if (!request.createValidate())
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        PlanPO oldPlan = planPOMapper.selectByPrimaryKey(request.getPlanId());
        if (oldPlan == null)
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);

        UnitPO oldUnit = unitPOMapper.findByPlanIdAndUniName(request.getPlanId(), request.getUnitName());
        if (oldUnit != null)
            throw new AdException(Constants.ErrorMsg.SAME_UNIT_NAME_ERROR);

        UnitPO unitPO = new UnitPO();
        unitPO.setPlanId(oldPlan.getId());
        unitPO.setBudget(request.getBudget());
        unitPO.setPositionType(request.getPositionType());
        unitPO.setUnitName(request.getUnitName());
        unitPOMapper.insertSelective(unitPO);
        return new AdUnitResponse(unitPO.getId(), unitPO.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createAdUnitKeyword(AdUnitKeywordRequest request) throws AdException {

        List<Long> unitIds = request.getUnitKeywords().stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds))
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        List<UnitKeywordPO> unitKeywordPOs  = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(unitKeyword -> {
                UnitKeywordPO unitKeywordPO = new UnitKeywordPO();
                unitKeywordPO.setUnitId(Math.toIntExact(unitKeyword.getUnitId()));
                unitKeywordPO.setKeyword(unitKeyword.getKeyword());
                unitKeywordPOs.add(unitKeywordPO);
            });
        }
        List<Long> ids = unitKeywordPOs.stream()
                .map(unitKeywordPOMapper::insertSelective)
                .collect(Collectors.toList());
        return new AdUnitKeywordResponse(ids);
    }

    @Override
    public AdUnitItResponse createAdUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getIts().stream()
                .map(AdUnitItRequest.UnitIt::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds))
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        List<UnitItPO> unitItPOs  = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getIts())) {
            request.getIts().forEach(unitIt -> {
                UnitItPO unitItPO = new UnitItPO();
                unitItPO.setUnitId(Math.toIntExact(unitIt.getUnitId()));
                unitItPO.setItTag(unitIt.getTag());
                unitItPOs.add(unitItPO);
            });
        }
        List<Long> ids = unitItPOs.stream()
                .map(unitItPOMapper::insertSelective)
                .collect(Collectors.toList());
        return new AdUnitItResponse(ids);
    }

    @Override
    public AdUnitDistrictResponse createAdUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts().stream()
                .map(AdUnitDistrictRequest.UnitDistrict::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds))
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        List<UnitDistrictPO> unitDistrictPOs  = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitDistricts())) {
            request.getUnitDistricts().forEach(unitDistrict -> {
                UnitDistrictPO unitDistrictPO = new UnitDistrictPO();
                unitDistrictPO.setUnitId(Math.toIntExact(unitDistrict.getUnitId()));
                unitDistrictPO.setProvince(unitDistrict.getProvince());
                unitDistrictPO.setCity(unitDistrict.getCity());
                unitDistrictPOs.add(unitDistrictPO);
            });
        }
        List<Long> ids = unitDistrictPOs.stream()
                .map(unitDistrictPOMapper::insertSelective)
                .collect(Collectors.toList());
        return new AdUnitDistrictResponse(ids);
    }

    @Override
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {

        List<Long> unitIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getUnitId)
                .collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getCreativeId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds) || !isRelatedCreativeExist(creativeIds))
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        List<CreativeUnitPO> creativeUnitPOs = new ArrayList<>();
        request.getUnitItems().forEach(creativeUnitItem -> {
            CreativeUnitPO creativeUnitPO = new CreativeUnitPO();
            creativeUnitPO.setCreativeId(creativeUnitItem.getCreativeId());
            creativeUnitPO.setUnitId(creativeUnitItem.getUnitId());
            creativeUnitPOs.add(creativeUnitPO);
        });
        List<Long> ids = creativeUnitPOs.stream()
                .map(creativeUnitPOMapper::insertSelective)
                .collect(Collectors.toList());
        return new CreativeUnitResponse(ids);
    }

    private boolean isRelatedUnitExist(List<Long> unitIds) {
        if (CollectionUtils.isEmpty(unitIds))
            return false;
        return unitPOMapper.findAllByIds(unitIds).size() ==
                new HashSet<>(unitIds).size();
    }

    private boolean isRelatedCreativeExist(List<Long> creativeIds) {
        if (CollectionUtils.isEmpty(creativeIds))
            return false;
        return creativePOMapper.findAllByIds(creativeIds).size() ==
                new HashSet<>(creativeIds).size();
    }
}
