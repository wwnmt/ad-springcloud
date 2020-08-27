package edu.nuaa.wwn.ad.service;

import edu.nuaa.wwn.ad.exception.AdException;
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

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 10:19
 */
public interface AdUnitService {

    AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createAdUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createAdUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createAdUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}
