package com.xing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xing.dao.ProductDao;
import com.xing.entity.Product;
import com.xing.service.ProductService;
import org.springframework.stereotype.Service;


@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {

}

