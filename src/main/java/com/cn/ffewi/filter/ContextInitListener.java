package com.cn.ffewi.filter;

import java.io.FileNotFoundException;

import org.springframework.util.Log4jConfigurer;

public class ContextInitListener{

    static {
        try {
          Log4jConfigurer.initLogging("classpath:config/log4j.properties");
        } catch (FileNotFoundException ex) {
          System.err.println("Cannot Initialize log4j");
        }
      }
}
