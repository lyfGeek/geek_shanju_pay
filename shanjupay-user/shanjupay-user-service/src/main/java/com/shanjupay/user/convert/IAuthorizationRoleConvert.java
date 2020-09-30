package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.authorization.RoleDTO;
import com.shanjupay.user.entity.AuthorizationRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IAuthorizationRoleConvert {

    IAuthorizationRoleConvert INSTANCE = Mappers.getMapper(IAuthorizationRoleConvert.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "tenantId", source = "tenantId")}
    )
    RoleDTO entity2dto(AuthorizationRole entity);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "tenantId", source = "tenantId")}
    )
    AuthorizationRole dto2entity(RoleDTO dto);

    List<RoleDTO> entityList2dto(List<AuthorizationRole> authorizationRole);

    List<AuthorizationRole> dtoList2entity(List<RoleDTO> roleDTOS);

}