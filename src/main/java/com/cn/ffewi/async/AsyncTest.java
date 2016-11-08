package com.cn.ffewi.async;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
/**
 * 
 * 类/接口注释
 * 
 * 测试spring 的异步功能
 * @createDate 2016年11月8日
 *
 */
@Service
@EnableAsync
public class AsyncTest {
    
    private static final Logger log = Logger.getLogger(AsyncTestDemo.class);
    
    @Async
    public String asyncMethodWithReturn(String str,AsyncTestDemo at){
        System.out.println("async start");
        try {
            Thread.sleep(6*1000);
            System.out.println("Async");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            System.err.println("timeout!!!");
            e.printStackTrace();
        }
        log.info(str);
        at.setResults("ok");
        return "ok";
    }
}
