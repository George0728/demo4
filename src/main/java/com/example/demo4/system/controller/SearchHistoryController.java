package com.example.demo4.system.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo4.system.entity.SearchHistory;
import com.example.demo4.system.entity.User;
import com.example.demo4.system.mapper.SearchHistoryMapper;
import com.example.demo4.system.service.SearchHistoryService;
import com.example.demo4.system.vo.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
@CrossOrigin //解决跨域
@RequestMapping("/system/search-history")
public class SearchHistoryController {

    @Autowired
    SearchHistoryService searchHistoryService;
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    /*使用GET传输*/
    @RequestMapping(value = "/pagelist",method = RequestMethod.GET)
    public IPage<SearchHistory> selectPage(@RequestParam("pageSize")Integer pageSize,@RequestParam("pageIndex")Integer pageIndex){
        log.info("selectPage start");
        IPage<SearchHistory> page = new Page<>(pageIndex,pageSize);
        QueryWrapper queryWrapper = Wrappers.<SearchHistory>query().orderByDesc("search_time");
        searchHistoryMapper.selectPage(page,queryWrapper);
        if(CollectionUtils.isNotEmpty(page.getRecords())){
            page.getRecords().forEach(data->{
                log.info("{}",data);
            });
        }
        log.info("selectPage end");
        return page;
    }

    @RequestMapping(value = "/addhistory",method = RequestMethod.GET)
    public AjaxResult addHistory(@RequestParam("searchText")String searchText, @RequestParam("searchEngine")String searchEngine){
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setSearchText(searchText);
        searchHistory.setSearchEngine(searchEngine);
        searchHistory.setSearchTime(new Date());
        try {
            searchHistoryService.save(searchHistory);
            return AjaxResult.success();
        } catch (Exception e) {
            String msg = StrUtil.format("添加搜索历史失败：{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg);
        }
    }

}
