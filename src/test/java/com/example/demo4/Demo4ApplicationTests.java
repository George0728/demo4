package com.example.demo4;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo4.dto.menutreedto.Children;
import com.example.demo4.dto.menutreedto.MenuTreeDTO;
import com.example.demo4.system.entity.MenuTree;
import com.example.demo4.system.service.MenuTreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Demo4ApplicationTests {

//    {
//
//        @Autowired
//        MenuTreeService menuTreeService;
//
//        /**
//         * 初始处理已有节点数据，目前只有两层
//         */
//        @Test
//        void resolvTreeNodeBatchSave() {
//        //region Str 字符串, 节点源数据
//        String str = "[\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"聚合API\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"API Docs\",\n" +
//                "                \"url\": \"https://tool.oschina.net/apidocs/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882027,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"API ref\",\n" +
//                "                \"url\": \"https://www.apiref.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882028,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟教程\",\n" +
//                "                \"url\": \"https://www.runoob.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882029,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"W3中文教程\",\n" +
//                "                \"url\": \"https://www.w3school.com.cn/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882030,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 3,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Adguard文档\",\n" +
//                "                \"url\": \"https://george0728.github.io/Web/adguard/en.htm\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882031,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 4,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882026,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 1,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"编程API\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Ajax\",\n" +
//                "                \"url\": \"https://www.runoob.com/ajax/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882033,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"BootStrap4\",\n" +
//                "                \"url\": \"https://code.z01.com/v4/docs/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882034,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"cnchar (v3.0.5)\",\n" +
//                "                \"url\": \"https://www.theajack.com/cnchar/guide/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882035,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"CSS3—API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/css3/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882036,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 3,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"CSS-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/cssref/css-reference.html\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882037,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 4,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882038,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Element\",\n" +
//                "                \"children\": [],\n" +
//                "                \"url\": \"https://element.eleme.cn/#/zh-CN/component/layout\",\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 5,\n" +
//                "                \"remark\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MAVEN\",\n" +
//                "                \"url\": \"https://www.runoob.com/maven/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882040,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 7,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"SQL\",\n" +
//                "                \"url\": \"https://www.runoob.com/sql/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882041,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 8,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTML5-API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/html5/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882042,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 9,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTMLDOM-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/htmldom\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882043,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 10,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTML-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/tags/html-reference.html\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882044,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 11,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Vue2\",\n" +
//                "                \"url\": \"https://v2.cn.vuejs.org/v2/guide/\",\n" +
//                "                \"remark\": \"https://v2.cn.vuejs.org/v2/guide/\",\n" +
//                "                \"id\": 1674563882045,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 12,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Java-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/java/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882046,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 13,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Java SE 11\",\n" +
//                "                \"url\": \"https://www.apiref.com/java11-zh\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882047,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 14,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JavaScript-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/js\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882048,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 15,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JavaScript-API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/js/index.html\",\n" +
//                "                \"remark\": \"http://www.aseoe.com/manual/js/index.html\",\n" +
//                "                \"id\": 1674563882049,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 16,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JDK中文手册\",\n" +
//                "                \"url\": \"https://tool.oschina.net/apidocs/apidoc?api=jdk-zh\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882050,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 17,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/jquery\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882051,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 18,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery—API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/jq/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882052,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 19,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery1.9 API -离线\",\n" +
//                "                \"url\": \"source/api/jquery-api-1.9/index.htm\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882053,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 20,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/manual/jquery/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882054,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 21,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JSON-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/json/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882055,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 22,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"XML-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/xml/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882056,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 23,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1675782344578,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MySQL安装使用教程\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://www.sjkjc.com/mysql/install-on-windows/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1675779252663,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MySQL-菜鸟\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://www.runoob.com/mysql/mysql-tutorial.html\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882032,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 2,\n" +
//                "        \"remark\": \"\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"在线工具\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"在线工具聚合\",\n" +
//                "                \"url\": \"https://tool.lu/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882058,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882059,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JSON工具\",\n" +
//                "                \"children\": [\n" +
//                "                    {\n" +
//                "                        \"id\": 1674610905051,\n" +
//                "                        \"level\": 2,\n" +
//                "                        \"label\": \"JSON生成Java实体\",\n" +
//                "                        \"children\": [],\n" +
//                "                        \"show\": false,\n" +
//                "                        \"url\": \"http://www.jsons.cn/json2java\"\n" +
//                "                    },\n" +
//                "                    {\n" +
//                "                        \"id\": 1675953136355,\n" +
//                "                        \"level\": 2,\n" +
//                "                        \"label\": \"JSON转Insert SQL\",\n" +
//                "                        \"children\": [],\n" +
//                "                        \"show\": false,\n" +
//                "                        \"url\": \"https://tableconvert.com/zh-cn/json-to-sql\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"unfold\": true\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882057,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 3,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674563882060,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"菜鸟教程\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674563882062,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Rust\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"url\": \"https://www.runoob.com/rust/rust-tutorial.html\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882061,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Linux\",\n" +
//                "                \"children\": [],\n" +
//                "                \"url\": \"https://www.runoob.com/linux/linux-tutorial.html\",\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"remark\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Regexp\",\n" +
//                "                \"url\": \"https://www.runoob.com/regexp/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882039,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 6,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"url\": \"\",\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 4,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674563882062,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"不可用iframe1\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"猎手导航33333\",\n" +
//                "                \"url\": \"http://www.lsdhss.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882063,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": [],\n" +
//                "                \"unfold\": true\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"资源分享4444444\",\n" +
//                "                \"url\": \"https://www.qiuziyuan.net/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882064,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"爱思资源网5555555\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882065,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 5,\n" +
//                "        \"remark\": \"\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674566619881,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"多媒体\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674733125414,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"腾讯视频\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://v.qq.com/\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"url\": \"https://v.qq.com/\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674566619130,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"报表数据\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674566840739,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"搜索历史\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"source/html/searchhistory.html\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1676070138599,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"在线搜索历史\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"source/html/searchonlinehistory.html\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"unfold\": true,\n" +
//                "        \"url\": \"http://192.168.88.8:8181/docs/note\"\n" +
//                "    }\n" +
//                "]";
//        //endregion
//        List<MenuTreeDTO> menuTreeDTOS = JSON.parseArray(str, MenuTreeDTO.class);
//
//        List<MenuTree> list = new ArrayList<>();
//
//        for(int i=0;i< menuTreeDTOS.size();i++){
//            MenuTreeDTO item = menuTreeDTOS.get(i);
//
//            MenuTree menuTree = new MenuTree();
//            menuTree.setLabel(item.getLabel());
//            menuTree.setLevel(1);
//            menuTree.setOrderNumber(i);
//            menuTree.setVisible(false);
//            menuTree.setUrl(item.getUrl());
//            menuTree.setParentId(0L);
//            menuTree.setId((long) (i+1));
//            list.add(menuTree);
//            if (CollectionUtil.isNotEmpty(item.getChildren())){
//                List<Children> children = item.getChildren();
//                for(int j=0;j < children.size();j++){
//                    Children childItem = children.get(j);
//                    MenuTree menuTree1 = new MenuTree();
//                    menuTree1.setLabel(childItem.getLabel());
//                    menuTree1.setLevel(2);
//                    menuTree1.setOrderNumber(j);
//                    menuTree1.setVisible(false);
//                    menuTree1.setUrl(childItem.getUrl());
//                    menuTree1.setParentId(menuTree.getId());
//                    list.add(menuTree1);
//                }
//            }
//        }
//
//        System.out.println(JSON.toJSONString(list));
//        menuTreeService.saveBatch(list);
//    }
//        @Test
//        void resolvTreeNodeOneSave() {
//        //region Str 字符串, 节点源数据
//        String str = "[\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"聚合API\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"API Docs\",\n" +
//                "                \"url\": \"https://tool.oschina.net/apidocs/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882027,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"API ref\",\n" +
//                "                \"url\": \"https://www.apiref.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882028,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟教程\",\n" +
//                "                \"url\": \"https://www.runoob.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882029,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"W3中文教程\",\n" +
//                "                \"url\": \"https://www.w3school.com.cn/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882030,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 3,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Adguard文档\",\n" +
//                "                \"url\": \"https://george0728.github.io/Web/adguard/en.htm\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882031,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 4,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882026,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 1,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"编程API\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Ajax\",\n" +
//                "                \"url\": \"https://www.runoob.com/ajax/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882033,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"BootStrap4\",\n" +
//                "                \"url\": \"https://code.z01.com/v4/docs/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882034,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"cnchar (v3.0.5)\",\n" +
//                "                \"url\": \"https://www.theajack.com/cnchar/guide/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882035,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"CSS3—API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/css3/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882036,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 3,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"CSS-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/cssref/css-reference.html\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882037,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 4,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882038,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Element\",\n" +
//                "                \"children\": [],\n" +
//                "                \"url\": \"https://element.eleme.cn/#/zh-CN/component/layout\",\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 5,\n" +
//                "                \"remark\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MAVEN\",\n" +
//                "                \"url\": \"https://www.runoob.com/maven/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882040,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 7,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"SQL\",\n" +
//                "                \"url\": \"https://www.runoob.com/sql/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882041,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 8,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTML5-API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/html5/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882042,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 9,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTMLDOM-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/htmldom\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882043,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 10,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"HTML-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/tags/html-reference.html\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882044,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 11,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Vue2\",\n" +
//                "                \"url\": \"https://v2.cn.vuejs.org/v2/guide/\",\n" +
//                "                \"remark\": \"https://v2.cn.vuejs.org/v2/guide/\",\n" +
//                "                \"id\": 1674563882045,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 12,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Java-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/java/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882046,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 13,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"Java SE 11\",\n" +
//                "                \"url\": \"https://www.apiref.com/java11-zh\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882047,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 14,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JavaScript-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/js\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882048,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 15,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JavaScript-API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/js/index.html\",\n" +
//                "                \"remark\": \"http://www.aseoe.com/manual/js/index.html\",\n" +
//                "                \"id\": 1674563882049,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 16,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JDK中文手册\",\n" +
//                "                \"url\": \"https://tool.oschina.net/apidocs/apidoc?api=jdk-zh\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882050,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 17,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/jquery\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882051,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 18,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery—API\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/jq/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882052,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 19,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery1.9 API -离线\",\n" +
//                "                \"url\": \"source/api/jquery-api-1.9/index.htm\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882053,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 20,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JQuery-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/manual/jquery/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882054,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 21,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JSON-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/json/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882055,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 22,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"XML-菜鸟\",\n" +
//                "                \"url\": \"https://www.runoob.com/xml/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882056,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 23,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1675782344578,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MySQL安装使用教程\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://www.sjkjc.com/mysql/install-on-windows/\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1675779252663,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"MySQL-菜鸟\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://www.runoob.com/mysql/mysql-tutorial.html\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882032,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 2,\n" +
//                "        \"remark\": \"\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"level\": 1,\n" +
//                "        \"label\": \"在线工具\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"在线工具聚合\",\n" +
//                "                \"url\": \"https://tool.lu/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882058,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882059,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"JSON工具\",\n" +
//                "                \"children\": [\n" +
//                "                    {\n" +
//                "                        \"id\": 1674610905051,\n" +
//                "                        \"level\": 2,\n" +
//                "                        \"label\": \"JSON生成Java实体\",\n" +
//                "                        \"children\": [],\n" +
//                "                        \"show\": false,\n" +
//                "                        \"url\": \"http://www.jsons.cn/json2java\"\n" +
//                "                    },\n" +
//                "                    {\n" +
//                "                        \"id\": 1675953136355,\n" +
//                "                        \"level\": 2,\n" +
//                "                        \"label\": \"JSON转Insert SQL\",\n" +
//                "                        \"children\": [],\n" +
//                "                        \"show\": false,\n" +
//                "                        \"url\": \"https://tableconvert.com/zh-cn/json-to-sql\"\n" +
//                "                    }\n" +
//                "                ],\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"unfold\": true\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"id\": 1674563882057,\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 3,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674563882060,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"菜鸟教程\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674563882062,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Rust\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"url\": \"https://www.runoob.com/rust/rust-tutorial.html\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1674563882061,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Linux\",\n" +
//                "                \"children\": [],\n" +
//                "                \"url\": \"https://www.runoob.com/linux/linux-tutorial.html\",\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"remark\": \"\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"菜鸟-Regexp\",\n" +
//                "                \"url\": \"https://www.runoob.com/regexp/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882039,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 6,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"url\": \"\",\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 4,\n" +
//                "        \"remark\": \"\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674563882062,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"不可用iframe1\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"猎手导航33333\",\n" +
//                "                \"url\": \"http://www.lsdhss.com/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882063,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 0,\n" +
//                "                \"children\": [],\n" +
//                "                \"unfold\": true\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"资源分享4444444\",\n" +
//                "                \"url\": \"https://www.qiuziyuan.net/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882064,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 1,\n" +
//                "                \"children\": []\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"爱思资源网5555555\",\n" +
//                "                \"url\": \"http://www.aseoe.com/manual/\",\n" +
//                "                \"remark\": \"\",\n" +
//                "                \"id\": 1674563882065,\n" +
//                "                \"show\": false,\n" +
//                "                \"order\": 2,\n" +
//                "                \"children\": []\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"order\": 5,\n" +
//                "        \"remark\": \"\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674566619881,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"多媒体\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674733125414,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"腾讯视频\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"https://v.qq.com/\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"url\": \"https://v.qq.com/\",\n" +
//                "        \"unfold\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 1674566619130,\n" +
//                "        \"level\": 2,\n" +
//                "        \"label\": \"报表数据\",\n" +
//                "        \"children\": [\n" +
//                "            {\n" +
//                "                \"id\": 1674566840739,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"搜索历史\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"source/html/searchhistory.html\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"id\": 1676070138599,\n" +
//                "                \"level\": 2,\n" +
//                "                \"label\": \"在线搜索历史\",\n" +
//                "                \"children\": [],\n" +
//                "                \"show\": false,\n" +
//                "                \"url\": \"source/html/searchonlinehistory.html\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"show\": false,\n" +
//                "        \"unfold\": true,\n" +
//                "        \"url\": \"http://192.168.88.8:8181/docs/note\"\n" +
//                "    }\n" +
//                "]";
//        //endregion
//        List<MenuTreeDTO> menuTreeDTOS = JSON.parseArray(str, MenuTreeDTO.class);
//        for(int i=0;i< menuTreeDTOS.size();i++){
//            MenuTreeDTO item = menuTreeDTOS.get(i);
//
//            MenuTree menuTree = new MenuTree();
//            menuTree.setLabel(item.getLabel());
//            menuTree.setLevel(1);
//            menuTree.setOrderNumber(i);
//            menuTree.setVisible(false);
//            menuTree.setUrl(item.getUrl());
//            menuTree.setParentId(0L);
//            menuTree.setId((long) (i+1));
//            menuTreeService.save(menuTree);
//            if (CollectionUtil.isNotEmpty(item.getChildren())){
//                List<Children> children = item.getChildren();
//                for(int j=0;j < children.size();j++){
//                    Children childItem = children.get(j);
//                    MenuTree menuTree1 = new MenuTree();
//                    menuTree1.setLabel(childItem.getLabel());
//                    menuTree1.setLevel(2);
//                    menuTree1.setOrderNumber(j);
//                    menuTree1.setVisible(false);
//                    menuTree1.setUrl(childItem.getUrl());
//                    menuTree1.setParentId(menuTree.getId());
//                    menuTreeService.save(menuTree1);
//                }
//            }
//        }
//    }
//
//        @Test
//        public void testnodes(){
//        List<Long> ids = new ArrayList<>();
//        long parentId = 0L;
//        ids.add(parentId);
//        getAllChildrenNodeIdsByParentId(ids, parentId);
//        System.out.println(ids);
//    }
//
//        public void getAllChildrenNodeIdsByParentId(List<Long> ids,long id){
//        QueryWrapper<MenuTree> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("parent_id",id);
//        List<MenuTree> list = menuTreeService.list(queryWrapper);
//        if(CollectionUtil.isNotEmpty(list)){
//            for(MenuTree item : list){
//                ids.add(item.getId());
//                getAllChildrenNodeIdsByParentId(ids, item.getId());
//            }
//        }
//
//    }
//
//    }
}
