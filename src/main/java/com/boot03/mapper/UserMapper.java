package com.boot03.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot03.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 刘泰源
 * @version 1.8
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //查询登录信息
    User selectOneByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    //添加
    int insertSelective(User user);
}
