package com.luomo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Article;

/**
 * ClassName: ArticleService
 * Package: com.luomo.service
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 8:36
 * @Version: v1.0
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
