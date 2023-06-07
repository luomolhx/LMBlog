package com.luomo.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: ArticleVo
 * Package: com.luomo.domian.vo
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/6 - 9:31
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVo {

    private Long id;
    // 标题
    private String title;
    // 文章摘要
    private String summary;
    // 所属分类名
    private String categoryName;
    // 缩略图
    private String thumbnail;
    // 访问量
    private Long viewCount;

    private Date createTime;

    private Date updateTime;
}
