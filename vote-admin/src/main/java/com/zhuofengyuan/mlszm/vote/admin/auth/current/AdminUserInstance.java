package com.zhuofengyuan.mlszm.vote.admin.auth.current;

import com.zhuofengyuan.mlszm.vote.admin.auth.security.FengtoosSecurityUser;
import com.zhuofengyuan.mlszm.vote.security.SecurityUser;
import com.zhuofengyuan.mlszm.vote.security.UserInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AdminUserInstance implements UserInstance {

    @Override
    public SecurityUser getCurrentUser() {

        var user = new FengtoosSecurityUser();
        BeanUtils.copyProperties(
                SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                user
        );
        return user;
    }
}
