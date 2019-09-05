package com.zhuofengyuan.mlszm.vote.admin.auth.security;

import com.zhuofengyuan.mlszm.vote.entity.Authorization;
import com.zhuofengyuan.mlszm.vote.entity.User;
import com.zhuofengyuan.mlszm.vote.service.IAuthorizationService;
import com.zhuofengyuan.mlszm.vote.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Order(1)
@Component
public class FengtoosUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;
    @Autowired
    IAuthorizationService authorizationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = this.userService.findByUsername(username);
        if(entity == null){
            throw new UsernameNotFoundException("用户名认证失败");
        }
        return this.createSecurityUser(entity);
    }

    private FengtoosSecurityUser createSecurityUser(User entity){
        String id = entity.getId();
        List<Authorization> auths = this.authorizationService.selectByUserId(id);

        List<GrantedAuthority> authorizations = auths.stream().filter(a -> StringUtils.isNotEmpty(a.getCode()))
                .map(a -> new SimpleGrantedAuthority(a.getCode())).collect(Collectors.toList());
        return new FengtoosSecurityUser(authorizations, entity.getId(), entity.getScreenName(), entity.getUsername(), entity.getPassword());
    }
}
