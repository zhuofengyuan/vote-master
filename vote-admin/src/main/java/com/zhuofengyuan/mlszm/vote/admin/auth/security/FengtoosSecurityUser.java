package com.zhuofengyuan.mlszm.vote.admin.auth.security;

import com.zhuofengyuan.mlszm.vote.security.SecurityUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
public class FengtoosSecurityUser extends SecurityUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 3945179659081211914L;

    private Collection<GrantedAuthority> authorities;

    public FengtoosSecurityUser(Collection<GrantedAuthority> authorities, String id, String nickName, String loginName, String loginPwd) {
        super(id, nickName, loginName, loginPwd);
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return this.getLoginPwd();
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
