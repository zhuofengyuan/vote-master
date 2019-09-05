package com.zhuofengyuan.mlszm.vote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuofengyuan.mlszm.vote.entity.Authorization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorizationMapper extends BaseMapper<Authorization> {

    List<Authorization> selectByUserId(@Param("userId") String userId);
}