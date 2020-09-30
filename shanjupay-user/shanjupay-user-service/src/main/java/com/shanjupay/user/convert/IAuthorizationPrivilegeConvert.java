package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.authorization.PrivilegeDTO;
import com.shanjupay.user.entity.AuthorizationPrivilege;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IAuthorizationPrivilegeConvert {

    IAuthorizationPrivilegeConvert INSTANCE = Mappers.getMapper(IAuthorizationPrivilegeConvert.class);

    PrivilegeDTO entity2dto(AuthorizationPrivilege entity);

    AuthorizationPrivilege dto2entity(PrivilegeDTO dto);

    List<PrivilegeDTO> entityList2dto(List<AuthorizationPrivilege> authorizationRole);

}
