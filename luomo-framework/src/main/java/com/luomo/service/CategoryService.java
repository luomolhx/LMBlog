package com.luomo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-06-05 23:10:06
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

