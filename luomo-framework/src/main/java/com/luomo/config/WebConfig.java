package com.luomo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebConfig
 * Package: com.luomo.config
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 10:45
 * @Version: v1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域的域名
                .allowedOriginPatterns("*")
                // 是否允许Cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST","DELETE","PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }
}
