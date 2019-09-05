package com.zhuofengyuan.mlszm.vote.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuofengyuan.mlszm.vote.entity.ProductCategory;
import com.zhuofengyuan.mlszm.vote.mapper.ProductCategoryMapper;
import com.zhuofengyuan.mlszm.vote.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-14
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements IProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> findTree() {
        return this.productCategoryMapper.selectTree();
    }
}
