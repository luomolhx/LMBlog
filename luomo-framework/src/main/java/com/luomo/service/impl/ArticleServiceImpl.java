package com.luomo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luomo.constants.SystemConstants;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Article;
import com.luomo.domian.entity.Category;
import com.luomo.domian.vo.ArticleDetailVo;
import com.luomo.domian.vo.ArticleVo;
import com.luomo.domian.vo.HotArticleVo;
import com.luomo.domian.vo.PageVo;
import com.luomo.mapper.ArticleMapper;
import com.luomo.service.ArticleService;
import com.luomo.service.CategoryService;
import com.luomo.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ClassName: ArticleServiceImpl
 * Package: com.luomo.service.impl
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 8:37
 * @Version: v1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseResult hotArticleList() {
        // 查询热门文章 封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        // 必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        // 最多只查询十条
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();
        // Bean拷贝
        List<HotArticleVo> vos = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);
        return ResponseResult.okResult(vos);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        // 查询条件
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果传入categoryId 就要求查询时要和传入的一致
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // 文章状态要正常
        lambdaQueryWrapper.eq(Article::getStatus, SystemConstants.CATEGORY_STATUS_NORMAL);
        // 且置顶文章需要排在最前面 对isTop进行排序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);
        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, lambdaQueryWrapper);
        // 查询categoryName
        // for循环方式
        /*
        List<Article> articles = page.getRecords();
        for (Article article : articles) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }
        */
        // stream流方式
        List<Article> articles = page.getRecords();
        // 获取分类id 查询分类名称
        // 把分类名设置给article
        articles.stream().map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());
        // 封装查询结果
        List<ArticleVo> articleVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleVo.class);
        PageVo pageVo = new PageVo(articleVos, page.getTotal());

        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        // 根据文章id 查询文章
        Article article = getById(id);
        // 封装成Vo
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        // 根据分类id 查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        // 封装响应并返回
        return ResponseResult.okResult(articleDetailVo);
    }


}
