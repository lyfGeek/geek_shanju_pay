package com.shanjupay.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 应用信息。
 */
@Data
@TableName("resource_application")
public class ResourceApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 应用名称。
     */
    @TableField("NAME")
    private String name;
    /**
     * 应用编码。
     */
    @TableField("CODE")
    private String code;
    /**
     * 租户 id。
     */
    @TableField("TENANT_ID")
    private Long tenantId;

}
