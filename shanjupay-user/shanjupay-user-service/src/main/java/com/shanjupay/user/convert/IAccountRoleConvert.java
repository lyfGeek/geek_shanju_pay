package com.shanjupay.user.convert;

import com.shanjupay.user.api.dto.tenant.AccountRoleDTO;
import com.shanjupay.user.entity.AccountRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IAccountRoleConvert {

    IAccountRoleConvert INSTANCE = Mappers.getMapper(IAccountRoleConvert.class);

    AccountRoleDTO entity2dto(AccountRole entity);

    AccountRole dto2entity(AccountRoleDTO dto);

    List<AccountRoleDTO> listEntity2dto(List<AccountRole> app);

}
