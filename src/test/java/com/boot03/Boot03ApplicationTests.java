package com.boot03;

import com.boot03.pojo.Emp;
import com.boot03.service.EmpService;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
@Slf4j
@SpringBootTest
class Boot03ApplicationTests {
    @Autowired
    EmpService empService;
    @Test
    @BeforeEach
    void contextLoads() {
        List<Emp> allEmp = empService.getAllEmp();
    }

}
