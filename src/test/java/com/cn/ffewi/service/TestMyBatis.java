package com.cn.ffewi.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;
import com.cn.ffewi.domain.User;
import com.cn.ffewi.logs.MyLogger;


@RunWith(MyLogger.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})
public class TestMyBatis {
    
    private final Logger logger = Logger.getLogger(TestMyBatis.class);
    
    @Resource(name="userService")
    private IUserService userService;
    
    @Test
    public void test1() {
      User user = userService.getUserById(1);
      logger.info(JSON.toJSONString(user));
    }
}
