package com.zhuofengyuan.mlszm.vote.service.impl;

import com.zhuofengyuan.mlszm.vote.entity.Player;
import com.zhuofengyuan.mlszm.vote.mapper.PlayerMapper;
import com.zhuofengyuan.mlszm.vote.service.IPlayerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-23
 */
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements IPlayerService {

}
