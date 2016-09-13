package com.cn.ffewi.dao;

import java.net.URL;

public class Test {
    public static void main(String[] args) {
        new Test().getClassPath();
    }
    
    public void getClassPath(){
        URL path = this.getClass().getResource("");
        System.out.println(path);
    }
}
