package com.zju.ad.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.ad.constant.Constants;
import com.zju.ad.dao.AdUserMapper;
import com.zju.ad.dto.CreateUserRequestDTO;
import com.zju.ad.entity.AdUser;
import com.zju.ad.exception.AdException;
import com.zju.ad.utils.CommonUtils;
import com.zju.ad.vo.CreateUserResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @Author: zjumic
 * @Date: created at 20:27 2019/9/21
 */
@Service
@Slf4j
public class UserService extends ServiceImpl<AdUserMapper, AdUser> {
    CreateUserResponseVO createUser(CreateUserRequestDTO requestDTO) throws AdException {

        AdUser oldUser = this.getOne(new QueryWrapper<AdUser>().eq("username", requestDTO.getUsername()));
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = new AdUser(requestDTO.getUsername(), CommonUtils.MD5(requestDTO.getUsername()));
        this.save(newUser);

        CreateUserResponseVO responseVO = new CreateUserResponseVO();
        BeanUtils.copyProperties(newUser, responseVO);

        return responseVO;
    }
}
