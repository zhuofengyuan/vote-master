package com.zhuofengyuan.mlszm.vote.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuofengyuan.mlszm.vote.entity.Product;
import com.zhuofengyuan.mlszm.vote.mapper.ProductMapper;
import com.zhuofengyuan.mlszm.vote.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fengtoos
 * @since 2019-06-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
