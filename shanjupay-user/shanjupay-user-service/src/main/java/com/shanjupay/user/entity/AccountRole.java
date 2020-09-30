package com.shanjupay.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 账号~角色关系。
 */
@Data
@TableName("account_role")
public class AccountRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键。
     */
//    @TableId("ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名。
     */
    @TableField("USERNAME")
    private String username;
    /**
     * 角色编码。
     */
    @TableField("ROLE_CODE")
    private String roleCode;
    /**
     * 租户 id。
     */
    @TableField("TENANT_ID")
    private Long tenantId;

}
