package com.boot03.mapper;
import org.apache.ibatis.annotations.Param;

import com.boot03.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot03.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 刘泰源
* @description 针对表【emp】的数据库操作Mapper
* @createDate 2022-08-05 21:03:37
* @Entity com.boot03.pojo.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    //根据ID进行删除
    int deleteById(@Param("id") Integer id);
    List<Emp> selectAll();
    //添加信息
    int insertSelective(Emp emp);
    // 根据Id进行查询
    Emp selectById(@Param("id") Integer id);
    //更改信息
    int updateSelective(Emp emp);
}




