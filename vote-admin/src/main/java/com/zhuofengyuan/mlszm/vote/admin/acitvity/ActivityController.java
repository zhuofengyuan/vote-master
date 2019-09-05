package com.zhuofengyuan.mlszm.vote.admin.acitvity;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuofengyuan.mlszm.vote.entity.Activity;
import com.zhuofengyuan.mlszm.vote.entity.Product;
import com.zhuofengyuan.mlszm.vote.exception.FengtoosException;
import com.zhuofengyuan.mlszm.vote.resp.RestResponseBo;
import com.zhuofengyuan.mlszm.vote.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  活动接口
 * </p>
 *
 * @author fengtoos
 * @since 2019-08-23
 */
@RestController
@RequestMapping("/admin/activity")
public class ActivityController {

    @Autowired
    IActivityService accountService;

    @GetMapping("/list")
    public RestResponseBo list(@RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
                               @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        var page = new Page<Activity>(pageNumber, pageSize);
        return RestResponseBo.listOk(this.accountService.page(page));
    }

    @PostMapping("/add")
    public RestResponseBo add(@RequestBody Activity entity){
        this.accountService.save(entity);
        return RestResponseBo.ok();
    }

    @PostMapping("/update")
    public RestResponseBo update(@RequestBody Activity entity){
        this.accountService.updateById(entity);
        return RestResponseBo.ok();
    }

    @DeleteMapping("/delete")
    public RestResponseBo delete(String id){
        this.accountService.removeById(id);
        return RestResponseBo.ok();
    }
}
