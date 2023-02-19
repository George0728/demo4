package com.example.demo4.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel(value="SearchHistory对象", description="")
public class SearchHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "使用的搜索引擎")
    private String searchEngine;

    @ApiModelProperty(value = "搜索内容")
    private String searchText;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "搜索时间")
    private Date searchTime;

    @ApiModelProperty(value = "备注")
    private String remark;


    public static final String SEARCH_ENGINE = "search_engine";

    public static final String SEARCH_TEXT = "search_text";

    public static final String SEARCH_TIME = "search_time";

    public static final String REMARK = "remark";

}
