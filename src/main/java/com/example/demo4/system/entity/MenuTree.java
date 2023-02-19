package com.example.demo4.system.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanson
 * @since 2023-02-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="MenuTree对象", description="")
public class MenuTree implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "菜单名称标签")
    private String label;

    @ApiModelProperty(value = "菜单分级")
    private Integer level;

    @ApiModelProperty(value = "url地址")
    private String url;

    @ApiModelProperty(value = "0=不显示，1=显示")
    private Boolean visible;

    @ApiModelProperty(value = "排序")
    private Integer orderNumber;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "备注")
    private String remark;


    public static final String LABEL = "label";

    public static final String LEVEL = "level";

    public static final String URL = "url";

    public static final String VISIBLE = "visible";

    public static final String ORDER_NUMBER = "order_number";

    public static final String PARENT_ID = "parent_id";

    public static final String REMARK = "remark";

}
