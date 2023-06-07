package com.luomo.controller;

import com.luomo.domian.ResponseResult;
import com.luomo.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: FriendLinkController
 * Package: com.luomo.controller
 * Description:
 *
 * @Author: luomo
 * @Create: 2023/6/7 - 21:54
 * @Version: v1.0
 */
@RestController
@RequestMapping("/link")
public class FriendLinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink() {
        return linkService.getAllLink();
    }
}
