package edu.nuaa.wwn.ad.service.impl;

import edu.nuaa.wwn.ad.constant.Constants;
import edu.nuaa.wwn.ad.dao.CreativePOMapper;
import edu.nuaa.wwn.ad.entity.CreativePO;
import edu.nuaa.wwn.ad.exception.AdException;
import edu.nuaa.wwn.ad.service.CreativeService;
import edu.nuaa.wwn.ad.vo.CreativeRequest;
import edu.nuaa.wwn.ad.vo.CreativeResponse;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-27
 * Time: 11:32
 */
@Service
public class CreativeServiceImpl implements CreativeService {

    private final CreativePOMapper creativePOMapper;

    public CreativeServiceImpl(CreativePOMapper creativePOMapper) {
        this.creativePOMapper = creativePOMapper;
    }

    @Override
    public CreativeResponse createAdCreative(CreativeRequest request) throws AdException {

        if (!request.validate())
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);

        CreativePO creativePO = request.convertToEntity();
        long id = creativePOMapper.insertSelective(creativePO);
        return new CreativeResponse(id, creativePO.getName());
    }
}
