package com.luomo.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageVo
 * Package: com.luomo.domian.vo
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/6 - 9:37
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private List rows;
    private Long total;
}
