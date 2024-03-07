package com.xing.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("serial")
public class UserRole extends Model<UserRole> implements Serializable {
    private static final long serialVersionUID = -43697783509024944L;

    private Integer id;

    private Integer userId;

    private String role;
}
