package com.cn.ffewi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.ffewi.domain.User;
import com.cn.ffewi.utils.ImageUtil;

@Controller
@RequestMapping("/user")
public class BaseController {

    private final Logger log = Logger.getLogger(BaseController.class);
    
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){
     //int userId = Integer.parseInt(request.getParameter("id"));
      User user = new User();
      user.setUserName("ffewi");
      model.addAttribute("user", user);
      return "showUser";
    }
    
    @RequestMapping("/getMsg")
    @ResponseBody
    public String content(){
        log.info("*************************************");
        return "<h>Hello my first page</h>";
    }
    
    @RequestMapping("/getImg")
    @ResponseBody
    public void getImage(HttpServletResponse response){
        Map<String, BufferedImage> img = ImageUtil.createImage();
        Set<String> keys = img.keySet();
        String index = "";
        for (String key : keys) {
            //System.out.println(key);
            index = key;
        }
        String s = "<img src='"+img.get(index)
        +"'></img>";
        //log.info(s);
        log.error(s);
        
        try {
            ImageIO.write(img.get(index), "JPEG", response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
