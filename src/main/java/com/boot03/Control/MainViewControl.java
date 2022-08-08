package com.boot03.Control;

import com.boot03.pojo.Emp;
import com.boot03.pojo.User;
import com.boot03.service.EmpService;
import com.boot03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 刘泰源
 * @version 1.8
 */
@Controller
public class MainViewControl {
    @Autowired
    UserService userService;
    @Autowired
    EmpService empService;
    /**
     * 登录页(首页)
     * @return
     */
    @GetMapping(value = {"/","/Login"})
    public String getLogin(){
        //当访问根路径时进入首页
        return "login";
    }

    /**
     * 登陆后的跳转
     * @return
     * 防止表单重复提交最好的办法就是重定向
     */
    @PostMapping("/Login")
    public String Login(User user,HttpSession session){
            if(userService.Login(user) != null) {
                session.setAttribute("user", user);
                return "redirect:main.html";
            }else {
                return "login";
            }
    }
    /**
     * 再次刷新就是转发,只会刷新本页面
     * @return
     */
    @GetMapping("main.html")
    public String mainPage(){
            return "main";
    }
    @GetMapping("/emp")
    public String EmpPage(Model model){
        List<Emp> allEmp = empService.getAllEmp();
        // 保存列表信息到请求域中
        model.addAttribute("List", allEmp);
        return "emp";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empService.deleteEmp(id);
        return "redirect:/emp";
    }
    @GetMapping("/save")
    public String saveUser(){
        return "saveuser";
    }
    @PostMapping("/saveUser")
    public String save(User user){
        userService.saveUser(user);
        return "login";
    }
    //跳转到添加页面
    @GetMapping("/toadd")
    public String toAdd() {
      return "addEmp";
    }
    @PostMapping("/add")
    public String add(Emp emp){
        empService.saveEmp(emp);
        return "redirect:/emp";
    }
    //跳转到更改页面
    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model) {
        Emp emp = empService.getEmpByid(id);
        model.addAttribute("emp", emp);
        return "updateEmp";
    }
    @PutMapping("/updateemp")
    public String updateEmp(Emp emp){
        empService.UpdateEmp(emp);
        return "redirect:/emp";
    }
}
