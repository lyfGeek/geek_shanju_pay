package com.shanjupay.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanjupay.user.entity.AuthorizationRolePrivilege;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色-权限关系 Mapper 接口。
 */
@Repository
public interface IAuthorizationRolePrivilegeMapper extends BaseMapper<AuthorizationRolePrivilege> {

    @Insert("<script>" +
            "INSERT INTO authorization_role_privilege(ROLE_ID,PRIVILEGE_ID) VALUES " +
            "<foreach collection='pids' item='item'  separator=','>(#{rid},#{item})</foreach> " +
            "</script>")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
    void insertRolePrivilege(@Param("rid") Long rid, @Param("pids") List<Long> pids);

}
