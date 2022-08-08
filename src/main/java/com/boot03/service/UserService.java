package com.boot03.service;

import com.boot03.pojo.User;

/**
 * @author 刘泰源
 * @version 1.8
 */
public interface UserService {
    User Login(User user);
    void saveUser(User user);
}
