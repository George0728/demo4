package com.example.demo4.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo4.system.mapper.UserMapper;
import com.example.demo4.system.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("testUser")
public class TestController {
    @Autowired
    UserMapper userMapper;

    //直接分页查询
    @RequestMapping(value = "/selectPage",method = RequestMethod.GET)
    public IPage<User> selectPage(){
        log.info("selectPage start");
        IPage<User> page = new Page<>(1,2);
        userMapper.selectPage(page,null);
        if(CollectionUtils.isNotEmpty(page.getRecords())){
            page.getRecords().forEach(data->{
                log.info("{}",data);
            });
        }
        log.info("selectPage end");
        return page;
    }
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public User selectById(@RequestParam("id")Integer id){
        log.info("selectById start");
        User user = userMapper.selectById(id);
        log.info("user:{}",user);
        log.info("selectById end");
        return user;
    }
}
