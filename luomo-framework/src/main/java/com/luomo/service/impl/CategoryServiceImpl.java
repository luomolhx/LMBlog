package com.luomo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luomo.constants.SystemConstants;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Article;
import com.luomo.domian.entity.Category;
import com.luomo.domian.vo.CategoryVo;
import com.luomo.mapper.CategoryMapper;
import com.luomo.service.ArticleService;
import com.luomo.service.CategoryService;
import com.luomo.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-06-05 23:10:06
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        // 查询文章表状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        // 获取文章的分类id 并去重
        Set<Long> categoryId = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        // 查询分类表中对应分类id的分类信息
        List<Category> categories = listByIds(categoryId);
        categories = categories.stream()
                .filter(category -> SystemConstants.CATEGORY_STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
        // 封装Vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}

