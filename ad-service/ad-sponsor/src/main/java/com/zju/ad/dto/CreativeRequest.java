package com.zju.ad.dto;

import com.zju.ad.constant.CommonStatus;
import com.zju.ad.entity.AdCreative;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: zjumic
 * @Date: created at 23:36 2019/9/24
 */
@Data
public class CreativeRequest {

    @ApiModelProperty(name = "name", value = "创意名称")
    private String name;

    @ApiModelProperty(name = "type", value = "组类型")
    private Byte type;

    @ApiModelProperty(name = "materialType", value = "物料类型", notes = "比如图片可以是bmp、jpg等")
    private Byte materialType;

    @ApiModelProperty(name = "height", value = "物料高度")
    private Integer height;

    @ApiModelProperty(name = "width", value = "物料宽度")
    private Integer width;

    @ApiModelProperty(name = "size", value = "物料大小")
    private Long size;

    @ApiModelProperty(name = "duration", value = "持续时长", notes = "视频不为0")
    private Integer duration = 0;

    @ApiModelProperty(name = "auditStatus", value = "审核状态")
    private Byte auditStatus;

    @ApiModelProperty(name = "userId", value = "用户id")
    private Long userId;

    @ApiModelProperty(name = "url", value = "url")
    private String url;

    public AdCreative convertToEntity() {

        AdCreative creative = new AdCreative();
        creative.setName(name);
        creative.setType(type);
        creative.setMaterialType(materialType);
        creative.setWidth(width);
        creative.setHeight(height);
        creative.setSize(size);
        creative.setDuration(duration);
        creative.setAuditStatus(CommonStatus.VALID.getStatus());
        creative.setUserId(userId);
        creative.setUrl(url);
        creative.setCreateTime(new Date());
        creative.setUpdateTime(creative.getCreateTime());

        return creative;
    }
}
