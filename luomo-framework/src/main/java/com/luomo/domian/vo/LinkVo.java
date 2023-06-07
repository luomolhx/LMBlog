package com.luomo.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: LinkVo
 * Package: com.luomo.domian.vo
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/7 - 22:07
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {
    private Long id;

    // 网站地址
    private String address;
    // 审核状态 (0代表审核通过，1代表审核未通过，2代表未审核)
    private String status;

    private String name;

    private String logo;

    private String description;
}
