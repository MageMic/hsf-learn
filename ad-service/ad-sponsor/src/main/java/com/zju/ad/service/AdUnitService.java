package com.zju.ad.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.ad.constant.Constants;
import com.zju.ad.dao.*;
import com.zju.ad.dto.*;
import com.zju.ad.entity.AdCreative;
import com.zju.ad.entity.AdPlan;
import com.zju.ad.entity.AdUnit;
import com.zju.ad.entity.unit_condition.AdUnitDistrict;
import com.zju.ad.entity.unit_condition.AdUnitIt;
import com.zju.ad.entity.unit_condition.AdUnitKeyword;
import com.zju.ad.entity.unit_condition.CreativeUnit;
import com.zju.ad.exception.AdException;
import com.zju.ad.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zjumic
 * @Date: created at 23:44 2019/9/23
 */
@Service
public class AdUnitService extends ServiceImpl<AdUnitMapper, AdUnit> {

    @Autowired
    private AdPlanMapper adPlanMapper;
    @Autowired
    private AdUnitKeywordMapper adUnitKeywordMapper;
    @Autowired
    private AdUnitItMapper adUnitItMapper;
    @Autowired
    private AdUnitDistrictMapper adUnitDistrictMapper;
    @Autowired
    private AdCreativeMapper adCreativeMapper;
    @Autowired
    private CreativeUnitMapper creativeUnitMapper;

    public AdUnitResponse createAdUnit(AdUnitRequest request) throws AdException {

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

    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {

        List<Long> unitIds = request.getUnitKeywords().stream().map(AdUnitKeywordRequest.UnitKeyword::getUnitId).collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<Long> ids = Collections.emptyList();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(i -> {
                AdUnitKeyword adUnitKeyword = new AdUnitKeyword(i.getUnitId(), i.getKeyword());
                adUnitKeywordMapper.insert(adUnitKeyword);
                ids.add(adUnitKeyword.getId());
            });
        }

        return new AdUnitKeywordResponse(ids);
    }

    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {

        List<Long> unitIds = request.getUnitIts().stream().map(AdUnitItRequest.UnitIt::getUnitId).collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<Long> ids = Collections.emptyList();
        if (!CollectionUtils.isEmpty(request.getUnitIts())) {
            request.getUnitIts().forEach(i -> {
                AdUnitIt adUnitIt = new AdUnitIt(i.getUnitId(), i.getItTag());
                adUnitItMapper.insert(adUnitIt);
                ids.add(adUnitIt.getId());
            });
        }
        return new AdUnitItResponse(ids);
    }

    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {

        List<Long> unitIds = request.getUnitDistricts().stream().map(AdUnitDistrictRequest.UnitDistrict::getUnitId).collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<Long> ids = Collections.emptyList();
        if (!CollectionUtils.isEmpty(request.getUnitDistricts())) {
            request.getUnitDistricts().forEach(i -> {
                AdUnitDistrict adUnitDistrict = new AdUnitDistrict(i.getUnitId(), i.getProvince(), i.getCity());
                adUnitDistrictMapper.insert(adUnitDistrict);
                ids.add(adUnitDistrict.getId());
            });
        }
        return new AdUnitDistrictResponse(ids);
    }

    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {

        List<Long> unitIds = request.getUnitItems().stream().map(CreativeUnitRequest.CreativeUnitItem::getUnitId)
                .collect(Collectors.toList());
        List<Long> creativeIds = request.getUnitItems().stream().map(CreativeUnitRequest.CreativeUnitItem::getCreativeId)
                .collect(Collectors.toList());

        if (!(isRelatedUnitExist(unitIds) && isRelatedCreativeExist(creativeIds))) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        List<CreativeUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems().forEach(i -> {
            CreativeUnit creativeUnit = new CreativeUnit(i.getCreativeId(), i.getUnitId());
            creativeUnitMapper.insert(creativeUnit);
            creativeUnits.add(creativeUnit);
        });

        List<Long> ids = creativeUnits.stream().map(CreativeUnit::getId).collect(Collectors.toList());
        return new CreativeUnitResponse(ids);
    }

    private boolean isRelatedUnitExist(List<Long> unitIds) {

        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }

        QueryWrapper<AdUnit> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdUnit::getId, unitIds);
        // 判断查出来的是否和传入的大小相等，用HashSet去重
        return this.getBaseMapper().selectList(queryWrapper).size() == new HashSet<>(unitIds).size();
    }

    private boolean isRelatedCreativeExist(List<Long> creativeIds) {

        if (CollectionUtils.isEmpty(creativeIds)) {
            return false;
        }

        QueryWrapper<AdCreative> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdCreative::getId, creativeIds);
        // 判断查出来的是否和传入的大小相等，用HashSet去重
        return adCreativeMapper.selectList(queryWrapper).size() == new HashSet<>(creativeIds).size();
    }
}
