package com.example.demo4.dto.menutreedto;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2023-02-12 3:19:53
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
@Data
public class MenuTreeDTO {

    private int level;
    private String label;
    private String url;
    private List<Children> children;
    private long id;
    private boolean show;
    private int order;
    private String remark;


}