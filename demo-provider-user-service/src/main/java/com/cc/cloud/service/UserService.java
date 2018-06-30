package com.cc.cloud.service;

import com.cc.cloud.entity.User;

import java.util.List;

/**
 * 类名称：UserService<br>
 * 类描述：<br>
 * 创建时间：2018年04月28日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public interface UserService {

    User findOne(String id);

    void save(User user);

    List<User> getListUser();
}
