package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ad_creative")
public class AdCreative {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "name", value = "创意名称")
    @TableField(value = "name", insertStrategy = FieldStrategy.NOT_NULL)
    private String name;

    @ApiModelProperty(name = "type", value = "组类型")
    @TableField(value = "type", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte type;

    @ApiModelProperty(name = "materialType", value = "物料类型", notes = "比如图片可以是bmp、jpg等")
    @TableField(value = "material_type", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte materialType;

    @ApiModelProperty(name = "height", value = "物料高度")
    @TableField(value = "height", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer height;

    @ApiModelProperty(name = "width", value = "物料宽度")
    @TableField(value = "width", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer width;

    @ApiModelProperty(name = "size", value = "物料大小")
    @TableField(value = "size", insertStrategy = FieldStrategy.NOT_NULL)
    private Long size;

    @ApiModelProperty(name = "duration", value = "持续时长", notes = "视频不为0")
    @TableField(value = "duration", insertStrategy = FieldStrategy.NOT_NULL)
    private Integer duration = 0;

    @ApiModelProperty(name = "auditStatus", value = "审核状态")
    @TableField(value = "audit_status", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte auditStatus;

    @ApiModelProperty(name = "userId", value = "用户id")
    @TableField(value = "user_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long userId;

    @ApiModelProperty(name = "url", value = "url")
    @TableField(value = "url", insertStrategy = FieldStrategy.NOT_NULL)
    private String url;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_Time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

}