package com.boot03.Configer;

import com.boot03.intersecpter.LoginIntersept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 刘泰源
 * @version 1.8
 * 配置拦截器什么时候工作和拦截那些请求
 */
@Configuration
public class WebConfiger implements WebMvcConfigurer {
    // 即添加一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 要添加那个拦截器
        registry.addInterceptor(new LoginIntersept())
                // 拦截那些请求
                .addPathPatterns("/**")
                // 要放行那些 但是静态资源一定要放行,否则页面的个事会放生变化
                .excludePathPatterns("/","/Login","/css/**","/fonts/**","/images/**","/js/**","/save","/saveUser");
    }
}
