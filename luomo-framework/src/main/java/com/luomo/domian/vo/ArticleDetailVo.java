package com.luomo.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: ArticleDetailVo
 * Package: com.luomo.domian.vo
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/7 - 21:14
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo {

    private Long id;
    // 标题
    private String title;
    //文章内容
    private String content;
    // 所属分类id
    private Long categoryId;
    // 所属分类名
    private String categoryName;
    // 访问量
    private Long viewCount;

    private Date createTime;
}
