package com.boot03.service;

import com.boot03.pojo.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 刘泰源
* @description 针对表【emp】的数据库操作Service
* @createDate 2022-08-05 21:03:37
*/
public interface EmpService extends IService<Emp> {
     List<Emp> getAllEmp();
     //删除方法
     void deleteEmp(Integer id);
     int saveEmp(Emp emp);
     //查询方法
     Emp getEmpByid(Integer id);
     //更改方法
     void UpdateEmp(Emp emp);
}
