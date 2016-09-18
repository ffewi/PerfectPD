package com.cn.ffewi.utils;

/**
 * 
 * 一个通用的分页工具类
 * 
 * @author wei.li@downjoy.com
 * @createDate 2016年9月18日
 *
 */
public class PageUtil {

    /**
     * 获取分页代码
     * 
     * @param targetUrl 目标地址
     * @param totalNum 总记录数
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @return
     */
    public String getPagation(String targetUrl, int totalNum, int currentPage, int pageSize) {
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "<font color=red>未查询到数据！</font>";
        }
        StringBuffer pageCode = new StringBuffer();
        pageCode.append("<li><a href='" + targetUrl + "?page=1'>首页</a></li>");
        if (currentPage == 1) {
            pageCode.append("<li class='disa" + "bled'><a " + "href='#'>上一页</a></li>");
        } else {
            pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage - 1)
                    + "'>上一页</a></li>");
        }

        for (int i = currentPage - 2; i <= currentPage + 2; i++) {
            if (i < 1 || i > totalPage) {
                continue;
            }
            if (i == currentPage) {
                pageCode.append("<li class='divider-vertical'><a href='#'>" + i + "</a></li>");
            } else {
                pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "'>" + i + "</a></li>");
            }

        }

        if (currentPage == totalPage) {
            pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
        } else {
            pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage + 1)
                    + "'>下一页</a></li>");
        }
        pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "'>尾页</a></li>");

        System.out.println("分页。。。" + pageCode.toString());
        return pageCode.toString();
    }
}
