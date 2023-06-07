package com.luomo.controller;

import com.luomo.domian.ResponseResult;
import com.luomo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ArticleController
 * Package: com.luomo.controller
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 8:40
 * @Version: v1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //    @GetMapping("/list")
//    public List<Article> test(){
//        return articleService.list();
//    }
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {

        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        ResponseResult result = articleService.articleList(pageNum, pageSize, categoryId);

        return result;
    }

    @GetMapping("/{aid}")
    public ResponseResult getArticleDetail(@PathVariable("aid") Long id) {

        return articleService.getArticleDetail(id);
    }
}
