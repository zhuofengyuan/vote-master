package com.zhuofengyuan.mlszm.vote.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhuofengyuan.mlszm.vote.exception.FengtoosException;
import com.zhuofengyuan.mlszm.vote.prop.WechatSettings;
import com.zhuofengyuan.mlszm.vote.service.IWechatService;
import com.zhuofengyuan.mlszm.vote.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WechatServiceImpl implements IWechatService {

    private static final String WXERRORCODE = "errcode";
    private static final String WXERRORMSG = "errmsg";
    private static final String WXTOKENKEY = "access_token";

    @Autowired

    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    WechatSettings settings;

    @Override
    public String getToken(String id) {
        if(StringUtils.isEmpty(id)){
            return null;
        }

        //主动获取
        String token = this.redisTemplate.opsForHash().get(settings.getAccessTokenKey(), id).toString();
        if(StringUtils.isEmpty(token)){
            token = this.executeApi(id);
        }

        return token;
    }

    @Override
    public String executeApi(String id) {
        var tokenObj = JSONObject.parseObject(HttpUtil.getInstance().get(settings.getToken()).body());
        if(tokenObj.containsKey(WXERRORCODE)){
            throw new FengtoosException(401, "获取凭证失败：" + tokenObj.getString(WXERRORMSG));
        }

        var token = tokenObj.getString(WXTOKENKEY);
        this.redisTemplate.opsForHash().put(settings.getAccessTokenKey(), id, token);
        return token;
    }
}
