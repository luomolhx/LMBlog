package com.luomo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luomo.domian.entity.Article;
import com.luomo.mapper.ArticleMapper;
import com.luomo.service.ArticleService;
import org.springframework.stereotype.Service;

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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {
}
