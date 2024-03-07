package com.xing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@TableName("user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 521456249133620050L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;



}

