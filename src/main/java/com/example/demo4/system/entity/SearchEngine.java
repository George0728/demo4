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
 * @since 2023-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SearchEngine对象", description="")
public class SearchEngine implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String engineName;

    @ApiModelProperty(value = "搜索链接")
    private String searchUrl;

    @ApiModelProperty(value = "搜索关键词")
    private String searchKey;

    @ApiModelProperty(value = "搜索框候选词")
    private String placeholder;

    @ApiModelProperty(value = "图标地址")
    private String iconUrl;

    @ApiModelProperty(value = "备注")
    private String remark;

    private Integer status;

    private String suggestUrl;

    private String suggestCallback;

    /**
     * 排序
     */
    private int orderNumber;


    public static final String SEARCH_URL = "search_url";

    public static final String SEARCH_KEY = "search_key";

    public static final String PLACEHOLDER = "placeholder";

    public static final String ICON_URL = "icon_url";

    public static final String REMARK = "remark";

}
