package edu.nuaa.wwn.ad.service;

import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.vo.CreativeRequest;
import edu.nuaa.wwn.ad.vo.CreativeResponse;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 11:25
 */
public interface CreativeService {

    CreativeResponse createAdCreative(CreativeRequest request) throws AdException;
}
