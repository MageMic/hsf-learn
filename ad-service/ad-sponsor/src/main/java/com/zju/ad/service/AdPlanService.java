package com.zju.ad.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.ad.constant.CommonStatus;
import com.zju.ad.constant.Constants;
import com.zju.ad.dao.AdPlanMapper;
import com.zju.ad.dao.AdUserMapper;
import com.zju.ad.dto.AdPlanGetRequest;
import com.zju.ad.dto.AdPlanRequest;
import com.zju.ad.entity.AdPlan;
import com.zju.ad.entity.AdUser;
import com.zju.ad.exception.AdException;
import com.zju.ad.utils.CommonUtils;
import com.zju.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: zjumic
 * @Date: created at 21:09 2019/9/21
 */
@Service
public class AdPlanService extends ServiceImpl<AdPlanMapper, AdPlan> {

    @Autowired
    private AdUserMapper userMapper;
    @Autowired
    private AdPlanMapper adPlanMapper;

    /**
     * 创建推广计划
     * @param request
     * @return
     * @throws AdException
     */
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        // 确保关联的user对象存在
        AdUser adUser =  userMapper.selectById(request.getUserId());
        if (adUser == null) {
            throw new AdException(Constants.ErrorMsg.CANNOT_FIND_RECORD);
        }
        QueryWrapper<AdPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdPlan::getUserId, request.getUserId()).eq(AdPlan::getPlanName, request.getPlanName());
        AdPlan oldPlan = this.getOne(queryWrapper);
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }
        AdPlan newAdPlan = new AdPlan(request.getUserId(), request.getPlanName(),
                CommonUtils.parseStringDate(request.getStartDate()), CommonUtils.parseStringDate(request.getEndDate()));
        this.save(newAdPlan);
        return new AdPlanResponse(newAdPlan.getId(), newAdPlan.getPlanName());
    }

    /**
     * 获取推广计划
     * @param getRequest
     * @return
     * @throws AdException
     */
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest getRequest) throws AdException {

        if (!getRequest.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        QueryWrapper<AdPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdPlan::getUserId, getRequest.getUserId()).in(AdPlan::getId, getRequest.getIds());

        return this.list(queryWrapper);
    }

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException {

        if (!request.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        QueryWrapper<AdPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdPlan::getUserId, request.getUserId()).eq(AdPlan::getId, request.getId());
        AdPlan plan = getOne(queryWrapper);
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.CANNOT_FIND_RECORD);
        }
        if (request.getPlanName() != null) {
            plan.setPlanName(request.getPlanName());
        }
        if (request.getStartDate() != null) {
            plan.setStartDate(CommonUtils.parseStringDate(request.getStartDate()));
        }
        if (request.getEndDate() != null) {
            plan.setEndDate(CommonUtils.parseStringDate(request.getEndDate()));
        }
        plan.setUpdateTime(new Date());
        this.saveOrUpdate(plan);

        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {

        if (!request.deleteValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        QueryWrapper<AdPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(AdPlan::getUserId, request.getUserId()).eq(AdPlan::getId, request.getId());
        AdPlan plan = getOne(queryWrapper);
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.CANNOT_FIND_RECORD);
        }

        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());

        this.saveOrUpdate(plan);
    }
}
