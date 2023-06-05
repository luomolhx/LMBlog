package com.luomo.utils;

import com.luomo.domian.entity.Article;
import com.luomo.domian.vo.HotArticleVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: BeanCopyUtils
 * Package: com.luomo.utils
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/5 - 22:24
 * @Version: v1.0
 */
public class BeanCopyUtils {
    private BeanCopyUtils() {
    }

    public static <V> V copyBean(Object source, Class<V> clazz) {
        // 创建目标对象
        V result = null;
        try {
            result = clazz.newInstance();
            // 实现属性copy
            BeanUtils.copyProperties(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回目标对象
        return result;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz) {
        // stream流方式
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Article article = new Article();
        article.setId(1L);
        article.setTitle("你好");

        HotArticleVo vo = copyBean(article, HotArticleVo.class);
        System.out.println(vo);
    }
}
