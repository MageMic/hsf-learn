package com.zju.ad.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.ad.constant.Constants;
import com.zju.ad.dao.AdPlanMapper;
import com.zju.ad.dao.AdUnitMapper;
import com.zju.ad.dto.AdUnitRequest;
import com.zju.ad.entity.AdPlan;
import com.zju.ad.entity.AdUnit;
import com.zju.ad.exception.AdException;
import com.zju.ad.vo.AdUnitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zjumic
 * @Date: created at 23:44 2019/9/23
 */
@Service
public class AdUnitService extends ServiceImpl<AdUnitMapper, AdUnit> {

    @Autowired
    private AdPlanMapper adPlanMapper;

    AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        AdPlan adPlan = adPlanMapper.selectById(request.getPlanId());
        if (adPlan == null) {
            throw new AdException(Constants.ErrorMsg.CANNOT_FIND_RECORD);
        }
        QueryWrapper<AdUnit> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdUnit::getPlanId, request.getPlanId()).eq(AdUnit::getUnitName, request.getUnitName());
        AdUnit oldAdUnit = this.getOne(queryWrapper);
        if (oldAdUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        AdUnit newAdUnit = new AdUnit(request.getPlanId(), request.getUnitName(), request.getPositionType(), request.getBudget());
        this.save(newAdUnit);

        return new AdUnitResponse(newAdUnit.getPlanId(), newAdUnit.getUnitName());
    }
}
