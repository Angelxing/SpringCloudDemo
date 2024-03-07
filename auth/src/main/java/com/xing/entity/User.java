package com.xing.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-03-07 02:43:06
 */
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = 521456249133620050L;

    private Integer id;

    private String name;

    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

