package com.zhuofengyuan.mlszm.vote.admin.comment;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuofengyuan.mlszm.vote.entity.Activity;
import com.zhuofengyuan.mlszm.vote.entity.Comment;
import com.zhuofengyuan.mlszm.vote.exception.FengtoosException;
import com.zhuofengyuan.mlszm.vote.resp.RestResponseBo;
import com.zhuofengyuan.mlszm.vote.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  评论接口
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    ICommentService commentService;

    @GetMapping("/list")
    public RestResponseBo list(@RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
                               @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        var page = new Page<Comment
                >(pageNumber, pageSize);
        if(page != null){
            throw new FengtoosException(500, "test");
        }
        return RestResponseBo.ok(this.commentService.page(page));
    }
}
