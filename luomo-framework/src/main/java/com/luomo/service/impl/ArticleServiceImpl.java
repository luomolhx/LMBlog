package com.luomo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luomo.constants.SystemConstants;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Article;
import com.luomo.domian.vo.ArticleVo;
import com.luomo.domian.vo.HotArticleVo;
import com.luomo.domian.vo.PageVo;
import com.luomo.mapper.ArticleMapper;
import com.luomo.service.ArticleService;
import com.luomo.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        // 封装查询结果
        List<ArticleVo> articleVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleVo.class);
        System.out.println(page.getTotal());
        PageVo pageVo = new PageVo(articleVos, page.getTotal());

        return ResponseResult.okResult(pageVo);
    }


}
