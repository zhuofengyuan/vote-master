package com.zhuofengyuan.mlszm.vote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-27
 */
@Data
@TableName("file")
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.NONE)
    private Long id;

    private String path;

    private String filename;

    private Integer type;

    private String createUser;

    private Date createTime;
}
