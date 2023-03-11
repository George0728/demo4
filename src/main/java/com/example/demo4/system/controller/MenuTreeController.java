package com.example.demo4.system.controller;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo4.system.entity.MenuTree;
import com.example.demo4.system.entity.SearchEngine;
import com.example.demo4.system.mapper.SearchEngineMapper;
import com.example.demo4.system.service.MenuTreeService;
import com.example.demo4.system.service.SearchEngineService;
import com.example.demo4.system.vo.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanson
 * @since 2023-02-12
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/system/menu-tree")
public class MenuTreeController {
    @Autowired
    MenuTreeService menuTreeService;



    /*使用GET传输*/
    @RequestMapping(value = "/pagelist",method = RequestMethod.GET)
    public AjaxResult selectPage(){
        QueryWrapper queryWrapper = Wrappers.<MenuTree>query().orderByAsc("order_number");
        List<MenuTree> list = null;
        try {
            list = menuTreeService.list(queryWrapper);
            return AjaxResult.success(list);
        } catch (Exception e) {
            String msg = StrUtil.format("查询菜单树异常{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg,list);
        }

    }
    /*使用GET传输*/
    @RequestMapping(value = "/insert-update",method = RequestMethod.GET)
    public AjaxResult updateMenuTree(@RequestParam("menuTreeStr") String menuTreeStr){
        try {
            MenuTree menuTree = JSON.parseObject(menuTreeStr, MenuTree.class);
            if(menuTree.getId() == null){
                menuTreeService.save(menuTree);
            }else {
                menuTreeService.updateById(menuTree);
            }
            return AjaxResult.success("保存成功",menuTree.getId());
        } catch (Exception e) {
            String msg = StrUtil.format("保存菜单树异常{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg);
        }

    }

    /**
     * 拖拽更新节点数据
     * @param dropType  拖拽类型： inner before
     * @param dragDataId 被拖动的节点数据id
     * @param dropDataId 目标节点数据id
     * @return
     */
    @RequestMapping(value = "/drag-drop",method = RequestMethod.GET)
    public AjaxResult updateDraggingData(@RequestParam("dropType") String dropType,
                                         @RequestParam("dragDataId") Long dragDataId,
                                         @RequestParam("dropDataId") Long dropDataId){
        try {
            MenuTree dragMenuTree = menuTreeService.getById(dragDataId);
            Long dragParentId = dragMenuTree.getParentId(); //被拖拽节点的父节点id
            MenuTree dropMenuTree = menuTreeService.getById(dropDataId);
            Long dropParentId = dropMenuTree.getParentId(); //目标拖拽节点的父节点id
            Integer dropNodeOrderNumber = dropMenuTree.getOrderNumber();
            //拖拽到其它子节点
            if("inner".equals(dropType)){
                //更新节点序号
                QueryWrapper queryWrapper = Wrappers.query()
                        .eq(MenuTree.PARENT_ID,dropDataId)
                        .orderByDesc(MenuTree.ORDER_NUMBER);
                List<MenuTree> list = menuTreeService.list(queryWrapper);
                Integer orderNumber = 0;
                if (CollectionUtils.isNotEmpty(list)) {
                    orderNumber = list.get(0).getOrderNumber();
                }
                dragMenuTree.setParentId(dropDataId);
                dragMenuTree.setOrderNumber(orderNumber+1);
                menuTreeService.updateById(dragMenuTree);
            }
            //同一父节点下移动顺序
            if("before".equals(dropType)){
                //父id相等说明是在同一级目录下拖拽,不相等说明不是在父节点内的拖拽，需要对其父节点进行重新赋值，其值为目标节点的父节点值，其余操作与同级拖拽相同。
                if(dragParentId.intValue() != dropParentId.intValue()){
                    // 将其拖拽出与其父节点同级的位置，
                    dragMenuTree.setParentId(dropParentId);
                }
                // 1.修改dragNode的序号为dropNode序号，2.修改dropNode以及其以后的节点顺序，递增1
                dragMenuTree.setOrderNumber(dropNodeOrderNumber);
                menuTreeService.updateById(dragMenuTree);
                dropMenuTree.setOrderNumber(dragMenuTree.getOrderNumber()+1);
                menuTreeService.updateById(dropMenuTree);

            }
            //region 同级进行拖拽时,需要知道目标节点排列序号,将拖拽节点的序号设置为目标节点,并且将目标节点及其后的同级节点逐个加1.
            QueryWrapper queryWrapper = Wrappers.query()
                    .gt(MenuTree.ORDER_NUMBER, dropNodeOrderNumber)
                    .eq(MenuTree.PARENT_ID,dropMenuTree.getParentId())
                    .orderByAsc(MenuTree.ORDER_NUMBER);
            List<MenuTree> list = menuTreeService.list(queryWrapper);
            for(int i = 0; i < list.size(); i++){
                MenuTree menuTree = list.get(i);
                menuTree.setOrderNumber(dropMenuTree.getOrderNumber()+1 + i);
            }
            menuTreeService.updateBatchById(list);
            //endregion
            return AjaxResult.success("保存成功");
        } catch (Exception e) {
            String msg = StrUtil.format("拖拽菜单树异常{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg);
        }

    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public AjaxResult deleteMenuTreeById(@RequestParam("id") long id){
        try {
            List<Long> ids = new ArrayList<>();
            ids.add(id);
            menuTreeService.removeByIds(getAllChildrenNodeIdsByParentId(ids,id));
            return AjaxResult.success("删除成功");
        } catch (Exception e) {
            String msg = StrUtil.format("删除菜单树异常{}",e.getMessage());
            log.error(msg);
            return AjaxResult.error(msg);
        }

    }

    /**
     * 递归获取父节点下所有子节点
     * @param ids
     * @param id
     * @return
     */
    public List<Long> getAllChildrenNodeIdsByParentId(List<Long> ids,long id){
        QueryWrapper<MenuTree> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        List<MenuTree> list = menuTreeService.list(queryWrapper);
        for(MenuTree item : list){
            ids.add(item.getId());
            getAllChildrenNodeIdsByParentId(ids, item.getId());
        }
        return ids;
    }



}
