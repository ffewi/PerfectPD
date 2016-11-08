package com.cn.ffewi.async;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.cn.ffewi.logs.MyLogger;

@RunWith(MyLogger.class)     
@ContextConfiguration(locations = {"classpath:config/spring-mybatis.xml"})
public class AsyncTestDemo {
    
    private final Logger log = Logger.getLogger(AsyncTestDemo.class);
    
    @Autowired
    private AsyncTest asyncTest;
    
    private String results;
    
    public void setResults(String str){
        this.results = str;
    }
    
    @Test
    public void testAsync() throws Exception {
        System.out.println("begin!");
        AsyncTestDemo at = new AsyncTestDemo();
        //asyncProtect.startAsync("jasljdflasjfklasjlfjlasdfjd");
        asyncTest.asyncMethodWithReturn("is comming async thread!",at);
        int timeCnt=0;
        while(true){
            if ("ok".equals(at.results)) {
                log.info("finished!");
                break;
            }
            Thread.sleep(1000);
            timeCnt++;
            System.out.println("wait ...:["+timeCnt+"]"+" results: "+at.results);
        }
        System.out.println("end!");
        Thread.sleep(3000);
    }
}
