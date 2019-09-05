package com.zhuofengyuan.mlszm.vote.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuofengyuan.mlszm.vote.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-14
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}
