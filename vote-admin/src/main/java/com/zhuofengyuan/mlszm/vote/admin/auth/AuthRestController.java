package com.zhuofengyuan.mlszm.vote.admin.auth;

import com.zhuofengyuan.mlszm.vote.prop.WechatSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/wechat")
public class AuthRestController {

    @Autowired
    WechatSettings wechatSettings;

    @GetMapping
    public String conn(String echostr){
        System.out.println(echostr);
        return echostr;
    }

    @GetMapping("/principal")
    public Principal getPrincipal(Principal user) {
        return user;
    }
}
