package com.zhuofengyuan.mlszm.vote.admin.product;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuofengyuan.mlszm.vote.entity.Product;
import com.zhuofengyuan.mlszm.vote.exception.FengtoosException;
import com.zhuofengyuan.mlszm.vote.resp.RestResponseBo;
import com.zhuofengyuan.mlszm.vote.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

/**
 * 产品控制器
 * @author fengtoos
 */
@RestController
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public RestResponseBo list(@RequestParam(name = "page", defaultValue = "0") Integer pageNumber,
                               @RequestParam(name = "limit", defaultValue = "10") Integer pageSize){
        var page = new Page<Product>(pageNumber, pageSize);
        if(page != null){
            throw new FengtoosException(500, "test");
        }
        return RestResponseBo.ok(this.productService.page(page));
    }

    @PostMapping("/add")
    public RestResponseBo add(@RequestBody Product product){
        this.productService.save(product);
        return RestResponseBo.ok();
    }

    @PostMapping("/update")
    public RestResponseBo update(@RequestBody Product product){
        this.productService.updateById(product);
        return RestResponseBo.ok();
    }

    @DeleteMapping("/delete")
    public RestResponseBo delete(String id){
        this.productService.removeById(id);
        return RestResponseBo.ok();
    }
}
