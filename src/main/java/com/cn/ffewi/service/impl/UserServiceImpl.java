package com.cn.ffewi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.ffewi.dao.IUserDao;
import com.cn.ffewi.domain.User;
import com.cn.ffewi.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    @Override
    public User getUserById(int userId) {
      // TODO Auto-generated method stub
      return this.userDao.selectByPrimaryKey(userId);
//        User user = new User();
//        user.setAge(23);
//        user.setId(1);
//        user.setPassword("123456");
//        user.setUserName("ffewi");
//        return user;
    }
}
