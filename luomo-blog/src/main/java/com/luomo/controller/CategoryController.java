package com.luomo.controller;

import com.luomo.domian.ResponseResult;
import com.luomo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: CategoryController
 * Package: com.luomo.controller
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 23:22
 * @Version: v1.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList(){
        return categoryService.getCategoryList();
    }
}
