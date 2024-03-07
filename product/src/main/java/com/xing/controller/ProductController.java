package com.xing.controller;


import com.xing.entity.Product;
import com.xing.service.ProductService;
import com.xing.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.xing.util.R.success;


@RestController
@RequestMapping("/product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;


    @RequestMapping("/list")
    public R selectAll() {
        return success(this.productService.list());
    }

    /**
     * 新增数据
     *
     * @param product 实体对象
     * @return 新增结果
     */
    @RequestMapping("/insert")
    public R insert(@RequestBody Product product) {
        return success(this.productService.save(product));
    }

    /**
     * 修改数据
     *
     * @param product 实体对象
     * @return 修改结果
     */
    @RequestMapping("/update")
    public R update(@RequestBody Product product) {
        return success(this.productService.updateById(product));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody List<String> idList) {
        return success(this.productService.removeByIds(idList));
    }
}

