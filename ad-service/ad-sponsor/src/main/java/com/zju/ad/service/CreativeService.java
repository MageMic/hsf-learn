package com.zju.ad.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zju.ad.dao.AdCreativeMapper;
import com.zju.ad.dto.CreativeRequest;
import com.zju.ad.entity.AdCreative;
import com.zju.ad.vo.CreativeResponse;
import org.springframework.stereotype.Service;

/**
 * @Author: zjumic
 * @Date: created at 23:35 2019/9/24
 */
@Service
public class CreativeService extends ServiceImpl<AdCreativeMapper, AdCreative> {

    CreativeResponse createCreative(CreativeRequest request) {

        AdCreative creative = request.convertToEntity();
        this.save(creative);

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
