package com.zhuofengyuan.mlszm.vote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-23
 */
@Data
@TableName("activity_type")
public class ActivityType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    private Long id;

    private String name;

    private Integer level;

    private String path;

    private String parentId;

    private String createUser;

    private Date createTime;

    private String number;
}
