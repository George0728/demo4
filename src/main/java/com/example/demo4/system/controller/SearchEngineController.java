package com.example.demo4.system.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo4.system.entity.SearchEngine;
import com.example.demo4.system.entity.SearchHistory;
import com.example.demo4.system.mapper.SearchEngineMapper;
import com.example.demo4.system.mapper.SearchHistoryMapper;
import com.example.demo4.system.service.SearchEngineService;
import com.example.demo4.system.service.SearchHistoryService;
import com.example.demo4.system.vo.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanson
 * @since 2023-02-09
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/system/search-engine")
public class SearchEngineController {

    @Autowired
    SearchEngineService searchEngineService;
    @Autowired
    SearchEngineMapper searchEngineMapper;


    /*使用GET传输*/
    @RequestMapping(value = "/pagelist",method = RequestMethod.GET)
    public AjaxResult selectPage(){
        QueryWrapper queryWrapper = Wrappers.<SearchEngine>query().orderByDesc("order_number");
        queryWrapper.eq("status",1);
        List<SearchEngine> list = null;
        try {
            list = searchEngineService.list(queryWrapper);
            return AjaxResult.success(list);
        } catch (Exception e) {
            String msg = StrUtil.format("查询搜索引擎异常{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg);
        }

    }

    @RequestMapping(value = "/addsearchengine",method = RequestMethod.GET)
    public AjaxResult addHistory(@RequestParam("searchText")String searchText, @RequestParam("searchEngine")String searchEngine){
        SearchEngine engine = new SearchEngine();

        try {
            searchEngineService.save(engine);
        } catch (Exception e) {
            log.error(StrUtil.format("添加搜索引擎失败：{}",e.getMessage()));
        }
        return AjaxResult.success();
    }


}
