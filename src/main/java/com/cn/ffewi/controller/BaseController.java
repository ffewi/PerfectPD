package com.cn.ffewi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.ffewi.domain.User;

@Controller
@RequestMapping("/user")
public class BaseController {

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){
      int userId = Integer.parseInt(request.getParameter("id"));
      User user = new User();
      user.setUserName("ffewi");
      model.addAttribute("user", user);
      return "showUser";
    }
}
