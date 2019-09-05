package com.zhuofengyuan.mlszm.vote.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuofengyuan.mlszm.vote.entity.Authorization;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-29
 */
public interface IAuthorizationService extends IService<Authorization> {

    List<Authorization> selectByUserId(String id);
}
