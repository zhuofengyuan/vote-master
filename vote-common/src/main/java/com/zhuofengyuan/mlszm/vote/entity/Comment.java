package com.zhuofengyuan.mlszm.vote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-23
 */
@Data
@TableName("comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    private Long id;

    private String content;

    private String images;

    private String createUser;

    private LocalDateTime createTime;

    private String playerId;


}
