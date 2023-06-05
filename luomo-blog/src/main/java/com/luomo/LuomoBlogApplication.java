package com.luomo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName: LuomoBlogApplication
 * Package: com.luomo
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/4 - 22:10
 * @Version: v1.0
 */
@SpringBootApplication
@MapperScan("com.luomo.mapper")
public class LuomoBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LuomoBlogApplication.class, args);
    }
}
