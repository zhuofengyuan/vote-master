package com.zhuofengyuan.mlszm.vote.admin.wx;

import com.zhuofengyuan.mlszm.vote.prop.WechatSettings;
import com.zhuofengyuan.mlszm.vote.service.IWechatService;
import com.zhuofengyuan.mlszm.vote.type.LoginType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/wx/api")
public class WechatForwardUrlController {

    @Autowired
    WechatSettings settings;
    @Autowired
    IWechatService wechatService;

    @GetMapping("/login")
    public ModelAndView loginAction(LoginType type){
        ModelAndView mv = new ModelAndView(new RedirectView(settings.getLogin()));
        return mv;
    }

    @GetMapping("/getToken")
    public @ResponseBody
    String getToken(String id){
        return wechatService.getToken(id);
    }
}
