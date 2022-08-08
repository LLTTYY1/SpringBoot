package com.boot03.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 刘泰源
 * @version 1.8
 */
@Controller
public class PhotoControl {
    @GetMapping("/upphoto")
    public String toPhoto(){
        return "upphoto";
    }
    // 当点击提交照片时,响应这个请求
    @PostMapping("/getphoto")
    public String getPhoto(@RequestPart("photo")MultipartFile photo) throws IOException {
        if(!photo.isEmpty()) {
            // 拿到原始的文件名字
            String originalFilename = photo.getOriginalFilename();
            photo.transferTo(new File("H:\\Photo\\" + originalFilename));
            System.out.println("你好");
            System.out.println("我也好");
        }
        return "redirect:main.html";
    }
}
