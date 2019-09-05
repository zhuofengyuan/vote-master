package com.zhuofengyuan.mlszm.vote.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuofengyuan.mlszm.vote.entity.User;
import com.zhuofengyuan.mlszm.vote.mapper.UserMapper;
import com.zhuofengyuan.mlszm.vote.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            return null;
        }
        return this.userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }
}
