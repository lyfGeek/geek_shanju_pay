package com.shanjupay.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shanjupay.user.entity.ResourceButton;
import org.springframework.stereotype.Repository;


/**
 * 菜单 Mapper 接口。
 */
@Repository
public interface IResourceButtonMapper extends BaseMapper<ResourceButton> {

   /* @Select("<script>" +
            "select a.`NAME`,a.`CODE`,b.* from resource_button b " +
            "LEFT JOIN resource_application a ON a.`CODE`=b.APPLICATION_CODE " +
            "where APPLICATION_CODE=#{applicationCode} " +
            "and PRIVILEGE_CODE in <foreach collection='privilegeCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "</script>")
    List<ResourceDTO> selectButtonByPrivilegeInApp(@Param("privilegeCodes") List<String> privilegeCodes, @Param("applicationCode") String applicationCode);
*/

}
