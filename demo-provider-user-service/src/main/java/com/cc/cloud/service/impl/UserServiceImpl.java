package com.cc.cloud.service.impl;

import com.cc.cloud.entity.User;
import com.cc.cloud.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：UserServiceImpl<br>
 * 类描述：<br>
 * 创建时间：2018年04月28日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    private static final List<User> userList = new ArrayList<User>();

    @Override
    public User findOne(String id) {
        if (userList.size() < 1) {
            User u = new User();
            u.setAge("20");
            u.setId(id);
            u.setName("ceshi");
            userList.add(u);
        }
        return userList.get(0);
    }

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getListUser(){
        return userList;
    }
}
