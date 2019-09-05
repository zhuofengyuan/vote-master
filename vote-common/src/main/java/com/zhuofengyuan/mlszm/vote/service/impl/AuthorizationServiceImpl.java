package com.zhuofengyuan.mlszm.vote.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuofengyuan.mlszm.vote.entity.Authorization;
import com.zhuofengyuan.mlszm.vote.mapper.AuthorizationMapper;
import com.zhuofengyuan.mlszm.vote.service.IAuthorizationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-29
 */
@Service
public class AuthorizationServiceImpl extends ServiceImpl<AuthorizationMapper, Authorization> implements IAuthorizationService {

    @Autowired
    AuthorizationMapper authorizationMapper;

    @Override
    public List<Authorization> selectByUserId(String id) {
        if(StringUtils.isEmpty(id)){
            return Collections.emptyList();
        }
        return this.authorizationMapper.selectByUserId(id);
    }
}
