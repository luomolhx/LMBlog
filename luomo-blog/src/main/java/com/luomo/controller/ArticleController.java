package com.luomo.controller;

import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Article;
import com.luomo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ResponseResult hotArticleList(){

        ResponseResult result = articleService.hotArticleList();
        return result;
    }
}
