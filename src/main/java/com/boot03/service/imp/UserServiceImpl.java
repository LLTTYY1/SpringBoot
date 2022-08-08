package com.boot03.service.imp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot03.mapper.UserMapper;
import com.boot03.pojo.User;
import com.boot03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘泰源
 * @version 1.8
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
   @Autowired
   UserMapper userMapper;
    @Override
    public User Login(User user) {
        return userMapper.selectOneByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }
}
