package com.xing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
public class Product extends Model<Product> {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;


}

