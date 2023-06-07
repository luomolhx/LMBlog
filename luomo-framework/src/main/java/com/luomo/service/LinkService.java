package com.luomo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luomo.domian.ResponseResult;
import com.luomo.domian.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 21:58:12
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

