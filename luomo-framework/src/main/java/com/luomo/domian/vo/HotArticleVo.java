package com.luomo.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: HotArticleVo
 * Package: com.luomo.domian.vo
 * Description:
 * @Author: luomo
 * @Create: 2023/6/5 - 22:05
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    private Long id;
    // 文章标题
    private String title;
    // 浏览量
    private Long viewCount;
}
