package com.boot03.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot03.pojo.Emp;
import com.boot03.service.EmpService;
import com.boot03.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 刘泰源
* @description 针对表【emp】的数据库操作Service实现
* @createDate 2022-08-05 21:03:37
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{
    @Autowired
    EmpMapper empMapper;
 // 查询所有信息
    @Override
    public List<Emp> getAllEmp() {
        return  empMapper.selectAll();
    }

    @Override
    public void deleteEmp(Integer id) {
       empMapper.deleteById(id);
    }

    @Override
    public int saveEmp(Emp emp) {
        return empMapper.insertSelective(emp);
    }

    @Override
    public Emp getEmpByid(Integer id) {
        return empMapper.selectById(id);
    }
//更改信息
    @Override
    public void UpdateEmp(Emp emp) {
        empMapper.updateSelective(emp);
    }
}




