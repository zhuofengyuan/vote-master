package com.zhuofengyuan.mlszm.vote.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuofengyuan.mlszm.vote.entity.ProductCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-14
 */
public interface IProductCategoryService extends IService<ProductCategory> {

    List<ProductCategory> findTree();
}
